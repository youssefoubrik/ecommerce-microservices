package com.oubrik.ecommerce.product;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProductRequest(
                Integer id,

                @NotBlank(message = "Product name is required") @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters") String name,

                @Size(max = 500, message = "Description cannot exceed 500 characters") String description,

                @PositiveOrZero(message = "Available quantity cannot be negative") double availableQuantity,

                @NotNull(message = "Price is required") @Positive(message = "Price must be greater than zero") BigDecimal price,

                @NotNull(message = "Product category is required") Integer categoryId) {

}
