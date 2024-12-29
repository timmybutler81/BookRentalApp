package com.butlert.bookrentalapp.validator;

public interface BaseValidator<T> {
    void validate(T object);
}
