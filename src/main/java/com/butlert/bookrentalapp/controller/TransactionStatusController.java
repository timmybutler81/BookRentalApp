package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.TransactionStatusDTO;
import com.butlert.bookrentalapp.service.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-status")
public class TransactionStatusController {

    @Autowired
    private TransactionStatusService transactionStatusService;

    @GetMapping
    public List<TransactionStatusDTO> getAllTransactionTypes() {
        return transactionStatusService.getAllTransactionStatuses();
    }

    @GetMapping("/{id}")
    public TransactionStatusDTO getTransactionTypeById(@PathVariable Long id) {
        return transactionStatusService.getTransactionStatusById(id);
    }

    @PostMapping("/add")
    public TransactionStatusDTO saveTransactionType(@RequestBody TransactionStatusDTO transactionStatusDTO) {
        return transactionStatusService.saveTransactionStatus(transactionStatusDTO);
    }
}
