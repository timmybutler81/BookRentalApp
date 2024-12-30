package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.TransactionStatus;
import com.butlert.bookrentalapp.dto.TransactionStatusDTO;

import java.util.List;

public interface TransactionStatusDAO {

    List<TransactionStatusDTO> findAllTransactionStatuses();

    TransactionStatusDTO findTransactionStatusById(Long id);

    TransactionStatusDTO saveTransactionStatus(TransactionStatus transactionStatus);

    TransactionStatusDTO findByTransactionStatusName(String transactionName);
}
