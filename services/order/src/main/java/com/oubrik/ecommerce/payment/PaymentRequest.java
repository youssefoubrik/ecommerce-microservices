package com.oubrik.ecommerce.payment;

import java.math.BigDecimal;

import com.oubrik.ecommerce.customer.CustomerResponse;
import com.oubrik.ecommerce.order.PaymentMethod;

public record PaymentRequest(
                BigDecimal amount,
                PaymentMethod paymentMethod,
                Integer orderId,
                String orderReference,
                CustomerResponse customer) {

}
