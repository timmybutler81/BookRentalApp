package com.butlert.bookrentalapp.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Format for the response
    private ResponseEntity<Object> buildResponse(String error, String message, HttpStatus status) {
        return ResponseEntity.status(status).body(new ErrorResponse(error, message, LocalDateTime.now()));
    }

    // Handle validation errors
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildResponse("Validation Error", ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Handle entity not found errors
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
        return buildResponse("Resource Not Found", ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle database-related errors
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
        return buildResponse("Database Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle generic runtime exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        return buildResponse("Application Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Catch-all handler for any unhandled exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        return buildResponse("Unexpected Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Inner static class for error response
    public static class ErrorResponse {
        private String error;
        private String message;
        private LocalDateTime timestamp;

        public ErrorResponse(String error, String message, LocalDateTime timestamp) {
            this.error = error;
            this.message = message;
            this.timestamp = timestamp;
        }

        public String getError() {
            return error;
        }

        public String getMessage() {
            return message;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
}
