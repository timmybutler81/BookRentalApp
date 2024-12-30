package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.*;
import com.butlert.bookrentalapp.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookRentalTransactionService {

    @Autowired
    private BookRentalTransactionDAO bookRentalTransactionDAO;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private TransactionTypeDAO transactionTypeDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TransactionStatusDAO transactionStatusDAO;

    public BookRentalTransactionDTO checkOutBook(Long bookLicenseId, Long userId) {
        // Resolve the BookLicense
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(bookLicenseId);
        if (!bookLicenseDTO.isAvailable()) {
            throw new RuntimeException("Book License is not available for checkout");
        }

        // Resolve the TransactionType
        TransactionTypeDTO transactionTypeDTO = transactionTypeDAO.findByTransactionTypeName("Check Out");

        // Resolve the User
        UserDTO userDTO = userDAO.findUserById(userId);

        // Resolve the TransactionStatus DTO
        TransactionStatusDTO transactionStatusDTO = transactionStatusDAO.findByTransactionStatusName("Success");

        // Update BookLicense availability
        bookLicenseDTO.setAvailable(false);
        bookLicenseDAO.updateLicenseAvailability(bookLicenseId, false); // Ensure this method exists and updates availability in DB

        // Create the Transaction
        BookRentalTransactionDTO bookRentalTransactionDTO = new BookRentalTransactionDTO();
        bookRentalTransactionDTO.setBookLicenseId(bookLicenseId);
        bookRentalTransactionDTO.setUserId(userDTO.getId());
        bookRentalTransactionDTO.setTransactionType(transactionTypeDTO.getTransactionTypeName());
        bookRentalTransactionDTO.setTransactionStatus(transactionStatusDTO.getTransactionStatusName());
        bookRentalTransactionDTO.setTransactionDate(LocalDate.now());
        bookRentalTransactionDTO.setDueDate(LocalDate.now().plusDays(userDTO.getUserType().getRentalDurationDays()));

        // Save and return DTO
        return bookRentalTransactionDAO.saveTransaction(bookRentalTransactionDTO);
    }

    public BookRentalTransactionDTO returnBook(Long bookLicenseId, Long userId) {
        // Resolve the BookLicense DTO
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(bookLicenseId);

        // Resolve the TransactionType DTO
        TransactionTypeDTO transactionTypeDTO = transactionTypeDAO.findByTransactionTypeName("Returned");

        // Resolve the TransactionStatus DTO
        TransactionStatusDTO transactionStatusDTO = transactionStatusDAO.findByTransactionStatusName("Success");

        // Resolve the User DTO
        UserDTO userDTO = userDAO.findUserById(userId);

        // Update BookLicense availability through the DAO
        bookLicenseDTO.setAvailable(true);
        bookLicenseDAO.updateLicenseAvailability(bookLicenseId, true);

        // Create the Transaction DTO
        BookRentalTransactionDTO bookRentalTransactionDTO = new BookRentalTransactionDTO();
        bookRentalTransactionDTO.setBookLicenseId(bookLicenseDTO.getId());
        bookRentalTransactionDTO.setUserId(userDTO.getId());
        bookRentalTransactionDTO.setTransactionType(transactionTypeDTO.getTransactionTypeName());
        bookRentalTransactionDTO.setTransactionStatus(transactionStatusDTO.getTransactionStatusName());
        bookRentalTransactionDTO.setTransactionDate(LocalDate.now());
        bookRentalTransactionDTO.setDateReturned(LocalDate.now());

        // Save and return the DTO using the DAO
        return bookRentalTransactionDAO.saveTransaction(bookRentalTransactionDTO);
    }

    public void createTransaction() {

    }
}
