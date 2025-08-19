package com.oubrik.ecommerce.order;

import java.math.BigDecimal;
import java.util.List;

import com.oubrik.ecommerce.product.ProductPurchaseRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
        Integer id,
        @NotBlank(message = "Order reference is required") String reference,
        @NotNull(message = "Order amount is required") @Positive(message = "Order amount must be positive") BigDecimal amount,
        @NotNull(message = "Payment method is required") PaymentMethod paymentMethod,
        @NotBlank(message = "Customer ID is required") String customerId,
        @NotEmpty(message = "At least one product is required") @Valid List<ProductPurchaseRequest> products) {

}
