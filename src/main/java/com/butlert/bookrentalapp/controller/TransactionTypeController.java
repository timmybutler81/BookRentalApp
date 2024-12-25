package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.TransactionTypeDTO;
import com.butlert.bookrentalapp.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-type")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping
    public List<TransactionTypeDTO> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }

    @GetMapping("/{id}")
    public TransactionTypeDTO getTransactionTypeById(@PathVariable Long id) {
        return transactionTypeService.getTransactionTypeById(id);
    }

    @PostMapping("/add")
    public TransactionTypeDTO saveTransactionType(@RequestBody TransactionTypeDTO transactionTypeDTO) {
        return transactionTypeService.saveTransactionType(transactionTypeDTO);
    }
}
