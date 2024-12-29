package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.TransactionTypeDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;

public class TransactionTypeValidator implements BaseValidator<TransactionTypeDTO> {

    @Override
    public void validate(TransactionTypeDTO transactionTypeDTO) {
        if (transactionTypeDTO.getTransactionTypeName() == null || transactionTypeDTO.getTransactionTypeName().isEmpty()) {
            throw new IllegalArgumentException("Transaction Type name must not be empty or null");
        }

        if (transactionTypeDTO.getTransactionTypeName().length() > 100) {
            throw new IllegalArgumentException("Transaction Type  name must less than 100 characters");
        }
    }
}
