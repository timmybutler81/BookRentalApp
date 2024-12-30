package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.TransactionStatusDAO;
import com.butlert.bookrentalapp.db.entity.TransactionStatus;
import com.butlert.bookrentalapp.db.mapper.TransactionStatusMapper;
import com.butlert.bookrentalapp.db.repository.TransactionStatusRepository;
import com.butlert.bookrentalapp.dto.TransactionStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionStatusDAOImp implements TransactionStatusDAO {

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    @Override
    public List<TransactionStatusDTO> findAllTransactionStatuses() {
        return transactionStatusRepository.findAll()
                .stream()
                .map(TransactionStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionStatusDTO findTransactionStatusById(Long id) {
        return transactionStatusRepository.findById(id)
                .map(TransactionStatusMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction Status not found"));
    }

    @Override
    public TransactionStatusDTO saveTransactionStatus(TransactionStatus transactionStatus) {
        TransactionStatus savedTransactionStatus = transactionStatusRepository.save(transactionStatus);
        return TransactionStatusMapper.toDTO(savedTransactionStatus);
    }

    @Override
    public TransactionStatusDTO findByTransactionStatusName(String transactionName) {
        return transactionStatusRepository.findByTransactionStatusName(transactionName)
                .map(TransactionStatusMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction Status not found"));
    }
}
