package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.db.entity.BookRentalTransaction;
import com.butlert.bookrentalapp.db.repository.BookRentalTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRentalTransactionDAOImp implements BookRentalTransactionDAO {

    @Autowired
    private BookRentalTransactionRepository repository;

    @Override
    public BookRentalTransaction saveTransaction(BookRentalTransaction transaction) {
        return repository.save(transaction);
    }
}
