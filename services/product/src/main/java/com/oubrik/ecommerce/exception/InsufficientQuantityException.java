package com.oubrik.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientQuantityException extends BaseException {
    public InsufficientQuantityException(Integer productId, String productName, Integer requestedQuantity,
            Integer availableQuantity) {
        super(String.format("Insufficient quantity for product %s (ID: %d). Requested: %d, Available: %d",
                productName, productId, requestedQuantity, availableQuantity));
    }

    public InsufficientQuantityException(String message) {
        super(message);
    }

    public InsufficientQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}
