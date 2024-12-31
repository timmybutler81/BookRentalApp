package com.butlert.bookrentalapp.db.mapper.rental;

import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.rental.TransactionStatusDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.db.entity.rental.BookRentalTransaction;
import com.butlert.bookrentalapp.db.mapper.book.BookLicenseMapper;
import com.butlert.bookrentalapp.db.mapper.user.UserMapper;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;

public class BookRentalTransactionMapper {

    public static BookRentalTransactionDTO toDTO(BookRentalTransaction transaction) {
        return new BookRentalTransactionDTO(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getBookLicense().getId(),
                transaction.getTransactionStatus().getId(),
                transaction.getCheckOutDate(),
                transaction.getDueDate(),
                transaction.getDateReturned()
        );
    }

    public static BookRentalTransaction toEntity(BookRentalTransactionDTO dto, UserDTO userDTO, BookLicenseDTO bookLicenseDTO, TransactionStatusDTO transactionStatusDTO) {
        BookRentalTransaction transaction = new BookRentalTransaction();
        transaction.setId(dto.getId());
        transaction.setUser(UserMapper.toEntity(userDTO)); // Set the user entity
        transaction.setBookLicense(BookLicenseMapper.toEntity(bookLicenseDTO)); // Set the book license entity
        transaction.setTransactionStatus(TransactionStatusMapper.toEntity(transactionStatusDTO));
        transaction.setCheckOutDate(dto.getCheckOutDate());
        transaction.setDueDate(dto.getDueDate());
        transaction.setDateReturned(dto.getDateReturned());
        return transaction;
    }
}
