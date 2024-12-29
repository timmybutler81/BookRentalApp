package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.TransactionStatusDAO;
import com.butlert.bookrentalapp.db.entity.TransactionStatus;
import com.butlert.bookrentalapp.db.mapper.TransactionStatusMapper;
import com.butlert.bookrentalapp.dto.TransactionStatusDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionStatusService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private TransactionStatusDAO transactionStatusDAO;

    public List<TransactionStatusDTO> getAllTransactionStatuses() {
        return transactionStatusDAO.findAllTransactionStatuses();
    }

    public TransactionStatusDTO getTransactionStatusById(Long id) {
        return transactionStatusDAO.findTransactionStatusById(id);
    }

    public TransactionStatusDTO saveTransactionStatus(TransactionStatusDTO transactionStatusDTO) {
        validatorImp.validate(transactionStatusDTO);
        TransactionStatus transactionStatus = TransactionStatusMapper.toEntity(transactionStatusDTO);
        return transactionStatusDAO.saveTransactionStatus(transactionStatus);
    }
}
