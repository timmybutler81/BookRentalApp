package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.TransactionTypeDAO;
import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.db.mapper.TransactionTypeMapper;
import com.butlert.bookrentalapp.db.repository.TransactionTypeRepository;
import com.butlert.bookrentalapp.dto.TransactionTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionTypeDAOImp implements TransactionTypeDAO {

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public List<TransactionTypeDTO> findAllTransactionTypes() {
        return transactionTypeRepository.findAll()
                .stream()
                .map(TransactionTypeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionTypeDTO findTransactionTypeById(Long id) {
        return transactionTypeRepository.findById(id)
                .map(TransactionTypeMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction Type not found"));
    }

    @Override
    public TransactionTypeDTO saveTransactionType(TransactionType transactionType) {
        TransactionType savedTransactionType = transactionTypeRepository.save(transactionType);
        return TransactionTypeMapper.toDTO(savedTransactionType);
    }
}
