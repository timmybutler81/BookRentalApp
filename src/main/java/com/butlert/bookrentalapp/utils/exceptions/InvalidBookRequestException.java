package com.butlert.bookrentalapp.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBookRequestException extends RuntimeException {

    public InvalidBookRequestException(String message) {
        super(message);
    }

    public InvalidBookRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}