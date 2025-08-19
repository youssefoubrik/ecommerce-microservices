package com.oubrik.ecommerce.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {
    private final KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;

    public void sendNotification(PaymentNotificationRequest request) {
        log.info("Seding notification with body <{}>", request);
        Message<PaymentNotificationRequest> message = MessageBuilder.withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
