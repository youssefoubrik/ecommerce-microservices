package com.oubrik.ecommerce.handler;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oubrik.ecommerce.exception.BaseException;
import com.oubrik.ecommerce.exception.CustomerClientException;
import com.oubrik.ecommerce.exception.OrderNotFoundException;
import com.oubrik.ecommerce.exception.ProductClientException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ErrorController {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex) {
        log.error("Caught BaseException", ex);
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred");
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("Caught MethodArgumentNotValidException", ex);
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
        return new ResponseEntity<ErrorResponse>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrderNotFoundException(OrderNotFoundException ex) {
        log.error("Caught OrderNotFoundException", ex);
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                "The specified order wasn't found");
        return new ResponseEntity<ErrorResponse>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerClientException.class)
    public ResponseEntity<ErrorResponse> handleCustomerClientException(CustomerClientException ex) {
        log.error("Caught CustomerClientException", ex);
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),
                "The customer service is currently unavailable");
        return new ResponseEntity<ErrorResponse>(errorDto, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(ProductClientException.class)
    public ResponseEntity<ErrorResponse> handleProductClientException(ProductClientException ex) {
        log.error("Caught ProductClientException", ex);
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(),
                "The product service is currently unavailable");
        return new ResponseEntity<ErrorResponse>(errorDto, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
