package com.oubrik.ecommerce.exception;

public class ProductClientException extends BaseException {
    public ProductClientException() {
    }

    public ProductClientException(String message) {
        super(message);
    }

    public ProductClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
