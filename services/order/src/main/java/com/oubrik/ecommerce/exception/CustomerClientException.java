package com.oubrik.ecommerce.exception;

public class CustomerClientException extends BaseException {
    public CustomerClientException() {
    }

    public CustomerClientException(String message) {
        super(message);
    }

    public CustomerClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
