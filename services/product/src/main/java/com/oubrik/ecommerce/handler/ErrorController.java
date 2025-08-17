package com.oubrik.ecommerce.handler;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.oubrik.ecommerce.exception.BaseException;
import com.oubrik.ecommerce.exception.InsufficientQuantityException;
import com.oubrik.ecommerce.exception.ProductNotFoundException;

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

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex) {
        log.error("Caught ProductNotFoundException", ex);
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                ex.getMessage() != null ? ex.getMessage() : "The specified product wasn't found");
        return new ResponseEntity<ErrorResponse>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientQuantityException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientQuantityException(InsufficientQuantityException ex) {
        log.error("Caught InsufficientQuantityException", ex);
        // Log the original detailed message but show a generic message to the user
        ErrorResponse errorDto = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                "The requested quantity exceeds the available inventory. Please try with a smaller quantity.");
        return new ResponseEntity<ErrorResponse>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
