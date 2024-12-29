package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.TransactionStatusDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class TransactionStatusValidator implements BaseValidator<TransactionStatusDTO> {

    @Override
    public void validate(TransactionStatusDTO transactionStatusDTO) {
        if (transactionStatusDTO.getTransactionStatusName() == null || transactionStatusDTO.getTransactionStatusName().isEmpty()) {
            throw new IllegalArgumentException("Transaction Type name must not be empty or null");
        }

        if (transactionStatusDTO.getTransactionStatusName().length() > 100) {
            throw new IllegalArgumentException("Transaction Type  name must less than 100 characters");
        }
    }
}
