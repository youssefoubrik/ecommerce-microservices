package com.oubrik.ecommerce.kafka;

import static com.oubrik.ecommerce.notification.NotificationType.ORDER_CONFIRMATION;
import static com.oubrik.ecommerce.notification.NotificationType.PAYMENT_CONFIRMATION;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.oubrik.ecommerce.email.EmailService;
import com.oubrik.ecommerce.kafka.order.OrderConfirmation;
import com.oubrik.ecommerce.kafka.payment.PaymentConfirmation;
import com.oubrik.ecommerce.notification.Notification;
import com.oubrik.ecommerce.notification.NotificationRepository;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
        private final NotificationRepository notificationRepository;
        private final EmailService emailService;

        // private final EmailService emailService;
        @KafkaListener(topics = "payment-topic")
        public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation)
                        throws MessagingException {
                log.info(String.format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
                notificationRepository.save(
                                Notification.builder().notificationType(PAYMENT_CONFIRMATION)
                                                .notificationDate(LocalDateTime.now())
                                                .paymentConfirmation(paymentConfirmation)
                                                .build());
                var customerName = paymentConfirmation.customerFirstName() + " "
                                + paymentConfirmation.customerLastName();
                emailService.sendPaymentSuccessEmail(paymentConfirmation.customerEmail(), customerName,
                                paymentConfirmation.amount(), paymentConfirmation.orderReference());
        }

        @KafkaListener(topics = "order-topic")
        public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation)
                        throws MessagingException {
                log.info(String.format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
                notificationRepository.save(
                                Notification.builder().notificationType(ORDER_CONFIRMATION)
                                                .notificationDate(LocalDateTime.now())
                                                .orderConfirmation(orderConfirmation)
                                                .build());

                // Check if customer data is available in the order confirmation
                if (orderConfirmation.customer() == null) {
                        log.warn("Customer information is missing in order confirmation for reference: {}",
                                        orderConfirmation.orderReference());
                        // Skip sending email since we don't have customer information
                        return;
                }

                var customerName = orderConfirmation.customer().firstName() + " "
                                + orderConfirmation.customer().lastName();
                emailService.sendOrderConfirmationEmail(orderConfirmation.customer().email(), customerName,
                                orderConfirmation.totalAmount(), orderConfirmation.orderReference(),
                                orderConfirmation.products());
        }
}
