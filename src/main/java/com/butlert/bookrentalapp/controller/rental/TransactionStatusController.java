package com.butlert.bookrentalapp.controller.rental;

import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;
import com.butlert.bookrentalapp.service.rental.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-status")
public class TransactionStatusController {

    @Autowired
    private TransactionStatusService transactionStatusService;

    @PostMapping("/add")
    public ResponseEntity<TransactionStatusDTO> addOrUpdateTransactionStatus(@RequestBody TransactionStatusDTO transactionStatusDTO) {
        return ResponseEntity.ok(transactionStatusService.addOrUpdateTransactionStatus(transactionStatusDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionStatusDTO> getTransactionTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionStatusService.getTransactionStatusById(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionStatusDTO>> getAllTransactionTypes() {
        return ResponseEntity.ok(transactionStatusService.getAllTransactionStatuses());
    }
}
