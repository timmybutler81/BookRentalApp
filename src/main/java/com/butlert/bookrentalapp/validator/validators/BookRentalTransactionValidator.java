package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class BookRentalTransactionValidator implements BaseValidator<BookRentalTransactionDTO> {

    @Override
    public void validate(BookRentalTransactionDTO bookRentalTransactionDTO) {
        if (bookRentalTransactionDTO.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        if (bookRentalTransactionDTO.getBookLicenseId() == null) {
            throw new IllegalArgumentException("Book License ID cannot be null");
        }
    }
}
