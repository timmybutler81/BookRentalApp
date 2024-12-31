package com.butlert.bookrentalapp.validator.validators.book;

import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class BookLicenseValidator implements BaseValidator<BookLicenseDTO> {

    @Override
    public void validate(BookLicenseDTO bookLicenseDTO) {
        if (bookLicenseDTO.getBook() == null) {
            throw new IllegalArgumentException("Book must not be null");
        }
        if (bookLicenseDTO.getBookStatus() == null) {
            throw new IllegalArgumentException("Book Status must not be null");
        }
        if (bookLicenseDTO.getLicenseKey() == null) {
            throw new IllegalArgumentException("Book License Key must not be null");
        }
        if (!bookLicenseDTO.isActiveFlag() && bookLicenseDTO.isActiveFlag()) {
            throw new IllegalArgumentException("Active flag must be true or false");
        }
    }
}
