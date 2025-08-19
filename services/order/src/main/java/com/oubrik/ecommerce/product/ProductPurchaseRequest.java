package com.oubrik.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductPurchaseRequest(@NotNull(message = "Product id is mandatory") Integer productId,
        @PositiveOrZero(message = "Available quantity cannot be negative") double quantity) {

}
