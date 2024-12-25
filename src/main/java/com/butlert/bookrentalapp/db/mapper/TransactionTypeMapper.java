package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.dto.TransactionTypeDTO;

public class TransactionTypeMapper {

    public static TransactionTypeDTO toDTO(TransactionType transactionType) {
        return new TransactionTypeDTO(
                transactionType.getId(),
                transactionType.getTransactionTypeName(),
                transactionType.isActiveFlag());
    }

    public static TransactionType toEntity(TransactionTypeDTO transactionTypeDTO) {
        TransactionType transactionType = new TransactionType();
        transactionType.setId(transactionTypeDTO.getId());
        transactionType.setTransactionTypeName(transactionTypeDTO.getTransactionTypeName());
        transactionType.setActiveFlag(transactionTypeDTO.isActiveFlag());
        return transactionType;
    }
}
