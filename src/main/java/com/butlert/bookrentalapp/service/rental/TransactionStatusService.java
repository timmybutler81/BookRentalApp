package com.butlert.bookrentalapp.service.rental;

import com.butlert.bookrentalapp.dao.rental.TransactionStatusDAO;
import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;
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

    public TransactionStatusDTO addOrUpdateTransactionStatus(TransactionStatusDTO transactionStatusDTO) {
        validatorImp.validate(transactionStatusDTO);
        return transactionStatusDAO.saveTransactionStatus(transactionStatusDTO);
    }

    public TransactionStatusDTO getTransactionStatusById(Long id) {
        return transactionStatusDAO.findTransactionStatusById(id);
    }

    public List<TransactionStatusDTO> getAllTransactionStatuses() {
        return transactionStatusDAO.findAllTransactionStatuses();
    }
}
