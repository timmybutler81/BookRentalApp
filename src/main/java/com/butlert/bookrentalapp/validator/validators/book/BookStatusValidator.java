package com.butlert.bookrentalapp.validator.validators.book;

import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class BookStatusValidator implements BaseValidator<BookStatusDTO> {

    @Override
    public void validate(BookStatusDTO bookStatusDTO) {
        if (bookStatusDTO.getBookStatusName() == null || bookStatusDTO.getBookStatusName().isEmpty()) {
            throw new IllegalArgumentException("Book Status name must not be empty or null");
        }
        if (bookStatusDTO.getBookStatusName().length() > 100) {
            throw new IllegalArgumentException("Book Status must not exceed 100 characters");
        }
        if (!bookStatusDTO.isActiveFlag() && !bookStatusDTO.isActiveFlag()) {
            throw new IllegalArgumentException("Active Flag must be true or false");
        }
    }
}
