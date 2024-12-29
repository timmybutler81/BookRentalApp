package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.BookLicenseDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class BookLicenseValidator implements BaseValidator<BookLicenseDTO> {

    @Override
    public void validate(BookLicenseDTO bookLicenseDTO) {
    }
}
