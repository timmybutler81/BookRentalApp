package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.BookRentalTransaction;

public interface BookRentalTransactionDAO {
    BookRentalTransaction saveTransaction(BookRentalTransaction transaction);
}
