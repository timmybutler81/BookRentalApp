package com.butlert.bookrentalapp.db.mapper.rental;

import com.butlert.bookrentalapp.db.entity.rental.BookRentalTransaction;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;

public class BookRentalTransactionMapper {

    public static BookRentalTransactionDTO toDTO(BookRentalTransaction transaction) {
        return new BookRentalTransactionDTO(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getBookLicense().getId(),
                transaction.getTransactionStatus().getTransactionStatusName(),
                transaction.getCheckOutDate(),
                transaction.getDueDate(),
                transaction.getDateReturned()
        );
    }

    public static BookRentalTransaction toEntity(BookRentalTransactionDTO dto) {
        BookRentalTransaction transaction = new BookRentalTransaction();
        transaction.setId(dto.getId());
        transaction.setCheckOutDate(dto.getCheckOutDate());
        transaction.setDueDate(dto.getDueDate());
        transaction.setDateReturned(dto.getDateReturned());
        return transaction;
    }
}
