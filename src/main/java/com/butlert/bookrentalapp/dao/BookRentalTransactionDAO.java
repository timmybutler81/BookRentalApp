package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.dto.BookRentalTransactionDTO;

public interface BookRentalTransactionDAO {
    BookRentalTransactionDTO saveTransaction(BookRentalTransactionDTO transactionDTO);
}
