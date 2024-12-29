package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.BookStatusDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class BookStatusValidator implements BaseValidator<BookStatusDTO> {

    @Override
    public void validate(BookStatusDTO bookStatusDTO) {
        if (bookStatusDTO.getBookStatusName() == null || bookStatusDTO.getBookStatusName().isEmpty()) {
            throw new IllegalArgumentException("Book Status name must not be empty or null");
        }
    }
}
