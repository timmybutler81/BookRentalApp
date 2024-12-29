package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.service.BookRentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class BookRentalTransactionController {

    @Autowired
    private BookRentalTransactionService transactionService;

    @PostMapping("/checkout")
    public BookRentalTransactionDTO checkOutBook(@RequestParam Long bookLicenseId,
                                                 @RequestParam Long userId) {
        return transactionService.checkOutBook(bookLicenseId, userId);
    }

    @PostMapping("/return")
    public BookRentalTransactionDTO returnBook(@RequestParam Long bookLicenseId,
                                               @RequestParam Long userId) {
        return transactionService.returnBook(bookLicenseId, userId);
    }
}
