package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.BookDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class BookValidator implements BaseValidator<BookDTO> {

    public void validate(BookDTO bookDTO) {
        if (bookDTO.getTitle() == null || bookDTO.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Book Title must not be empty or null");
        }

        if (bookDTO.getTitle().length() > 255) {
            throw new IllegalArgumentException("Genre name must less than 255 characters");
        }
    }

}
