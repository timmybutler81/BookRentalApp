package com.butlert.bookrentalapp.service.rental;

import com.butlert.bookrentalapp.dao.rental.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentalTransactionService {

    @Autowired
    private BookRentalTransactionDAO bookRentalTransactionDAO;


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
