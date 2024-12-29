package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.db.entity.BookRentalTransaction;
import com.butlert.bookrentalapp.db.entity.TransactionType;
import com.butlert.bookrentalapp.db.entity.User;
import com.butlert.bookrentalapp.db.mapper.BookRentalTransactionMapper;
import com.butlert.bookrentalapp.db.repository.BookLicenseRepository;
import com.butlert.bookrentalapp.db.repository.TransactionStatusRepository;
import com.butlert.bookrentalapp.db.repository.TransactionTypeRepository;
import com.butlert.bookrentalapp.db.repository.UserRepository;
import com.butlert.bookrentalapp.dto.BookRentalTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookRentalTransactionService {

    @Autowired
    private BookRentalTransactionDAO transactionDAO;

    @Autowired
    private BookLicenseRepository bookLicenseRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionStatusRepository transactionStatusRepository;

    public BookRentalTransactionDTO checkOutBook(Long bookLicenseId, Long userId) {
        BookLicense bookLicense = bookLicenseRepository.findById(bookLicenseId)
                .orElseThrow(() -> new RuntimeException("Book License not found"));
        //check availability
        if (!bookLicense.isAvailable()) {
            throw new RuntimeException("Book License is not available for checkout");
        }

        TransactionType transactionType = transactionTypeRepository.findByTransactionTypeName("Check Out")
                .orElseThrow(() -> new RuntimeException("Transaction Type not found"));
        //finding user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        bookLicense.setAvailable(false);
        bookLicenseRepository.save(bookLicense);
        //transaction creationg
        BookRentalTransaction transaction = new BookRentalTransaction();
        transaction.setBookLicense(bookLicense);
        transaction.setUser(user);
        transaction.setTransactionType(transactionType);
        transaction.setTransactionStatus(transactionStatusRepository.findByTransactionStatusName("Success").orElseThrow());
        transaction.setTransactionDate(LocalDate.now());

        transaction.setDueDate(LocalDate.now().plusDays(user.getUserType().getRentalDurationDays()));

        return BookRentalTransactionMapper.toDTO(transactionDAO.saveTransaction(transaction));
    }

    public BookRentalTransactionDTO returnBook(Long bookLicenseId, Long userId) {
        BookLicense bookLicense = bookLicenseRepository.findById(bookLicenseId)
                .orElseThrow(() -> new RuntimeException("Book License not found"));

        TransactionType transactionType = transactionTypeRepository.findByTransactionTypeName("Return")
                .orElseThrow(() -> new RuntimeException("Transaction Type not found"));
        //finding user
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        bookLicense.setAvailable(true);
        bookLicenseRepository.save(bookLicense);
        //creating the transaction
        BookRentalTransaction transaction = new BookRentalTransaction();
        transaction.setBookLicense(bookLicense);
        transaction.setUser(user);
        transaction.setTransactionType(transactionType);
        transaction.setTransactionStatus(transactionStatusRepository.findByTransactionStatusName("Success").orElseThrow());
        transaction.setTransactionDate(LocalDate.now());
        transaction.setDateReturned(LocalDate.now());

        return BookRentalTransactionMapper.toDTO(transactionDAO.saveTransaction(transaction));
    }
}
