package com.butlert.bookrentalapp.validator.validators.rental;

import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class TransactionStatusValidator implements BaseValidator<TransactionStatusDTO> {

    @Override
    public void validate(TransactionStatusDTO transactionStatusDTO) {
        if (transactionStatusDTO.getTransactionStatusName() == null || transactionStatusDTO.getTransactionStatusName().isEmpty()) {
            throw new IllegalArgumentException("Transaction Status name must not be empty or null");
        }
        if (transactionStatusDTO.getTransactionStatusName().length() > 100) {
            throw new IllegalArgumentException("Transaction Status must not exceed 100 characters");
        }
        if (!transactionStatusDTO.isActiveFlag() && !transactionStatusDTO.isActiveFlag()) {
            throw new IllegalArgumentException("Active Flag must be true or false");
        }
    }
}
