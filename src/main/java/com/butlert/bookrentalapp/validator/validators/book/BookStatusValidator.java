package com.butlert.bookrentalapp.validator.validators.book;

import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BookStatusValidator implements BaseValidator<BookStatusDTO> {

    private static final Logger logger = LoggerFactory.getLogger(BookStatusValidator.class);

    @Override
    public void validate(BookStatusDTO bookStatusDTO) {
        if (bookStatusDTO.getBookStatusName() == null || bookStatusDTO.getBookStatusName().isEmpty()) {
            logger.warn("Book status cannot be empty or null {}", bookStatusDTO.getBookStatusName());
            throw new IllegalArgumentException("Book Status name must not be empty or null");
        }
        if (bookStatusDTO.getBookStatusName().length() > 100) {
            logger.warn("Book status has invalid length {}", bookStatusDTO.getBookStatusName());
            throw new IllegalArgumentException("Book Status must not exceed 100 characters");
        }
        if (!bookStatusDTO.isActiveFlag() && !bookStatusDTO.isActiveFlag()) {
            logger.warn("Book Status Active Flag must be true or false {}", bookStatusDTO.isActiveFlag());
            throw new IllegalArgumentException("Active Flag must be true or false");
        }
    }
}
