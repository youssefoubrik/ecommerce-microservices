package com.oubrik.ecommerce.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.oubrik.ecommerce.customer.CustomerClient;
import com.oubrik.ecommerce.customer.CustomerResponse;
import com.oubrik.ecommerce.exception.CustomerClientException;
import com.oubrik.ecommerce.exception.OrderNotFoundException;
import com.oubrik.ecommerce.kafka.OrderConfirmation;
import com.oubrik.ecommerce.kafka.OrderProducer;
import com.oubrik.ecommerce.orderline.OrderLineRequest;
import com.oubrik.ecommerce.orderline.OrderLineService;
import com.oubrik.ecommerce.payment.PaymentClient;
import com.oubrik.ecommerce.payment.PaymentRequest;
import com.oubrik.ecommerce.product.ProductClient;
import com.oubrik.ecommerce.product.ProductPurchaseRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
        private final CustomerClient customerClient;
        private final ProductClient productClient;
        private final OrderRepository orderRespository;
        private final OrderMapper orderMapper;
        private final OrderLineService orderLineService;
        private final OrderProducer orderProducer;
        private final PaymentClient paymentClient;

        public Integer createOrder(OrderRequest order) {
                CustomerResponse customerResponse = customerClient.findCustomerById(order.customerId())
                                .orElseThrow(
                                                () -> new CustomerClientException(
                                                                "Customer not found with ID: " + order.customerId()));
                var purchasedProducts = productClient.purchaseProducts(order.products());
                Order savedOrder = orderRespository.save(orderMapper.toOrder(order));
                for (ProductPurchaseRequest productPurchaseRequest : order.products()) {
                        orderLineService.saveOrderLine(
                                        new OrderLineRequest(
                                                        null,
                                                        savedOrder.getId(),
                                                        productPurchaseRequest.productId(),
                                                        productPurchaseRequest.quantity()));
                }
                paymentClient.createPayment(new PaymentRequest(
                                order.amount(),
                                order.paymentMethod(), order.id(), order.reference(), customerResponse));

                orderProducer.sendOrderConfirmation(new OrderConfirmation(
                                order.reference(),
                                order.amount(),
                                order.paymentMethod(),
                                customerResponse,
                                purchasedProducts));
                return order.id();
        }

        public List<OrderResponse> findAllOrders() {
                return orderRespository.findAll().stream().map(orderMapper::toOrderResponse)
                                .collect(Collectors.toList());
        }

        public OrderResponse findById(Integer orderId) {
                return orderRespository.findById(orderId).map(orderMapper::toOrderResponse)
                                .orElseThrow(() -> new OrderNotFoundException(
                                                "Order not found with ID: " + orderId));
        }
}
