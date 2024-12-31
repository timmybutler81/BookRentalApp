package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.rental.TransactionStatusDAO;
import com.butlert.bookrentalapp.db.entity.rental.TransactionStatus;
import com.butlert.bookrentalapp.db.mapper.rental.TransactionStatusMapper;
import com.butlert.bookrentalapp.db.repository.rental.TransactionStatusRepository;
import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionStatusDAOImp implements TransactionStatusDAO {

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    @Override
    public TransactionStatusDTO saveTransactionStatus(TransactionStatusDTO transactionStatusDTO) {
        TransactionStatus transactionStatus = TransactionStatusMapper.toEntity(transactionStatusDTO);
        TransactionStatus savedTransactionStatus = transactionStatusRepository.save(transactionStatus);
        return TransactionStatusMapper.toDTO(savedTransactionStatus);
    }

    @Override
    public TransactionStatusDTO findTransactionStatusById(Long id) {
        TransactionStatus transactionStatus = transactionStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction Status not found"));
        return TransactionStatusMapper.toDTO(transactionStatus);
    }

    @Override
    public List<TransactionStatusDTO> findAllTransactionStatuses() {
        return transactionStatusRepository.findAll()
                .stream()
                .map(TransactionStatusMapper::toDTO)
                .collect(Collectors.toList());
    }




}
