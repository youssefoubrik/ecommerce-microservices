package com.oubrik.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.oubrik.ecommerce.customer.CustomerResponse;
import com.oubrik.ecommerce.order.PaymentMethod;
import com.oubrik.ecommerce.product.ProductPurchaseResponse;

public record OrderConfirmation(String orderReference, BigDecimal totalAmount, PaymentMethod paymentMethod,
        CustomerResponse customerResponse, List<ProductPurchaseResponse> products) {

}
