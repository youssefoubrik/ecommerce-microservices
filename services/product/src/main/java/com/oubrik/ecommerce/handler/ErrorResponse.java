package com.oubrik.ecommerce.handler;

/**
 * Record for standardized error response
 */
public record ErrorResponse(int status, String message) {
}
