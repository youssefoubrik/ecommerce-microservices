package com.oubrik.ecommerce.notification;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.oubrik.ecommerce.kafka.order.OrderConfirmation;
import com.oubrik.ecommerce.kafka.payment.PaymentConfirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Notification {
    @Id
    private String id;
    private NotificationType notificationType;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
