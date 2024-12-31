package com.butlert.bookrentalapp.dao.rental;

import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;

import java.util.List;

public interface TransactionStatusDAO {
    TransactionStatusDTO saveTransactionStatus(TransactionStatusDTO transactionStatusDTO);

    TransactionStatusDTO findTransactionStatusById(Long id);

    List<TransactionStatusDTO> findAllTransactionStatuses();
}
