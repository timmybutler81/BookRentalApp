package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.*;
import com.butlert.bookrentalapp.dto.BookRentalTransactionDTO;

public class BookRentalTransactionMapper {

    public static BookRentalTransactionDTO toDTO(BookRentalTransaction transaction) {
        return new BookRentalTransactionDTO(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getBookLicense().getId(),
                transaction.getTransactionType().getTransactionTypeName(),
                transaction.getTransactionStatus().getTransactionStatusName(),
                transaction.getTransactionDate(),
                transaction.getDueDate(),
                transaction.getDateReturned()
        );
    }

    public static BookRentalTransaction toEntity(BookRentalTransactionDTO dto) {
        BookRentalTransaction transaction = new BookRentalTransaction();
        transaction.setId(dto.getId());
        User user = new User();
        user.setId(dto.getUserId());
        transaction.setUser(user);
        BookLicense bookLicense = new BookLicense();
        bookLicense.setId(dto.getBookLicenseId());
        transaction.setBookLicense(bookLicense);
        transaction.setTransactionDate(dto.getTransactionDate());
        transaction.setDueDate(dto.getDueDate());
        transaction.setDateReturned(dto.getDateReturned());
        return transaction;
    }
}
