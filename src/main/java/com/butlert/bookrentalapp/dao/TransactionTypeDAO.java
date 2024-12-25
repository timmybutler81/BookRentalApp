package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.dto.TransactionTypeDTO;

import java.util.List;

public interface TransactionTypeDAO {

    List<TransactionTypeDTO> findAllTransactionTypes();

    TransactionTypeDTO findTransactionTypeById(Long id);

    TransactionTypeDTO saveTransactionType(TransactionType transactionType);
}
