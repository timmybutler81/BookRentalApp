package com.butlert.bookrentalapp.db.mapper.rental;

import com.butlert.bookrentalapp.db.entity.rental.TransactionStatus;
import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;

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
