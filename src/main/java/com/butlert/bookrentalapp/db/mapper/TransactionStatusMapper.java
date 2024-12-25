package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.TransactionStatus;
import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.dto.TransactionStatusDTO;
import com.butlert.bookrentalapp.dto.TransactionTypeDTO;

public class TransactionStatusMapper {

    public static TransactionStatusDTO toDTO(TransactionStatus transactionStatus) {
        return new TransactionStatusDTO(
                transactionStatus.getId(),
                transactionStatus.getTransactionStatusName(),
                transactionStatus.isActiveFlag());
    }

    public static TransactionStatus toEntity(TransactionStatusDTO transactionTypeDTO) {
        TransactionStatus transactionStatus = new TransactionStatus();
        transactionStatus.setId(transactionTypeDTO.getId());
        transactionStatus.setTransactionStatusName(transactionTypeDTO.getTransactionStatusName());
        transactionStatus.setActiveFlag(transactionTypeDTO.isActiveFlag());
        return transactionStatus;
    }
}
