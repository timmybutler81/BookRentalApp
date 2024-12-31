package com.butlert.bookrentalapp.service.rental;

import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.rental.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookRentalTransactionService {

    @Autowired
    private BookRentalTransactionDAO bookRentalTransactionDAO;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ValidatorImp validator;

    public BookRentalTransactionDTO checkoutBook(Long licenseId, Long userId) {
        //validate book license
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(licenseId);
        validator.validate(bookLicenseDTO);
        if (!bookLicenseDTO.isAvailable()) {
            throw new RuntimeException("Book License is not available for checkout");
        }
        //validate user
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        bookLicenseDAO.updateLicenseAvailability(licenseId, false);
        //check out book
        BookRentalTransactionDTO bookRentalTransactionDTO = new BookRentalTransactionDTO();
        bookRentalTransactionDTO.setBookLicenseId(bookLicenseDTO.getId());
        bookRentalTransactionDTO.setUserId(userDTO.getId());
        bookRentalTransactionDTO.setTransactionStatus("Success");
        bookRentalTransactionDTO.setCheckOutDate(LocalDate.now());
        bookRentalTransactionDTO.setDueDate(LocalDate.now().plusDays(userDTO.getUserType().getRentalDurationDays()));

        return bookRentalTransactionDAO.saveTransaction(bookRentalTransactionDTO);
    }

    public BookRentalTransactionDTO returnBook(Long licenseId, Long userId) {
        //make sure user has a checked out book
        Optional<BookRentalTransactionDTO> existingTransaction = Optional.ofNullable(bookRentalTransactionDAO.findTransactionByLicenseAndUser(licenseId, userId));
        if (existingTransaction.isEmpty()) {
            throw new IllegalArgumentException("No existing transaction found");
        }
        //validate book license
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(licenseId);
        validator.validate(bookLicenseDTO);
        //validate user
        UserDTO userDTO = userDAO.findUserById(userId);
        validator.validate(userDTO);
        bookLicenseDAO.updateLicenseAvailability(licenseId, true);
        //update existing found transaction
        BookRentalTransactionDTO bookRentalTransactionUpdate = existingTransaction.get();
        bookRentalTransactionUpdate.setTransactionStatus("Success");
        bookRentalTransactionUpdate.setDateReturned(LocalDate.now());

        return bookRentalTransactionDAO.saveTransaction(bookRentalTransactionUpdate);
    }

    public BookRentalTransactionDTO getBookRentalTransactionById(Long id) {
        return bookRentalTransactionDAO.findBookRentalTransactionById(id);
    }

    public List<BookRentalTransactionDTO> getAllBookRentalTransactions() {
        return bookRentalTransactionDAO.findAllBookRentalTransactions();
    }

    public List<BookRentalTransactionDTO> getTransactionByBookLicenseId(Long bookLicenseId) {
        return bookRentalTransactionDAO.findTransactionByBookLicenseId(bookLicenseId);
    }

    public List<BookRentalTransactionDTO> getTransactionsByUserId(Long userId) {
        return bookRentalTransactionDAO.findTransactionsByUserId(userId);
    }
}
