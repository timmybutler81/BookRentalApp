package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.db.entity.BookRentalTransaction;
import com.butlert.bookrentalapp.db.mapper.BookRentalTransactionMapper;
import com.butlert.bookrentalapp.db.repository.BookRentalTransactionRepository;
import com.butlert.bookrentalapp.dto.BookRentalTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRentalTransactionDAOImp implements BookRentalTransactionDAO {

    @Autowired
    private BookRentalTransactionRepository bookRentalTransactionRepository;

    @Override
    public BookRentalTransactionDTO saveTransaction(BookRentalTransactionDTO transactionDTO) {
        BookRentalTransaction transaction = BookRentalTransactionMapper.toEntity(transactionDTO);
        BookRentalTransaction savedTransaction = bookRentalTransactionRepository.save(transaction);
        return BookRentalTransactionMapper.toDTO(savedTransaction);
    }
}
