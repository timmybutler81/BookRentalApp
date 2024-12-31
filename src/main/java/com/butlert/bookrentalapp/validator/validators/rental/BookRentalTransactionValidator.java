package com.butlert.bookrentalapp.validator.validators.rental;

import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
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

        if (bookRentalTransactionDTO.getCheckOutDate() == null) {
            throw new IllegalArgumentException("Check Out Date cannot be null");
        }
    }
}
