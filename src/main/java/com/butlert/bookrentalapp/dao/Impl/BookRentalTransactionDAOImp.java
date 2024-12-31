package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.rental.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.db.entity.rental.BookRentalTransaction;
import com.butlert.bookrentalapp.db.mapper.rental.BookRentalTransactionMapper;
import com.butlert.bookrentalapp.db.repository.rental.BookRentalTransactionRepository;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public BookRentalTransactionDTO findBookRentalTransactionById(Long id) {
        BookRentalTransaction bookRentalTransaction = bookRentalTransactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book Rental Transaction not found"));
        return BookRentalTransactionMapper.toDTO(bookRentalTransaction);
    }

    @Override
    public List<BookRentalTransactionDTO> findAllBookRentalTransactions() {
        return bookRentalTransactionRepository.findAll()
                .stream()
                .map(BookRentalTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookRentalTransactionDTO> findTransactionByBookLicenseId(Long bookLicenseId) {
        return bookRentalTransactionRepository.findTransactionByBookLicenseId(bookLicenseId)
                .stream()
                .map(BookRentalTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookRentalTransactionDTO findTransactionByLicenseAndUser (Long licenseId, Long userId) {
        BookRentalTransaction bookRentalTransaction = bookRentalTransactionRepository.findTransactionByLicenseAndUser(licenseId, userId);
        return BookRentalTransactionMapper.toDTO(bookRentalTransaction);
    }

    @Override
    public List<BookRentalTransactionDTO> findTransactionsByUserId (Long userId) {
        return bookRentalTransactionRepository.findTransactionsByUserId(userId)
                .stream()
                .map(BookRentalTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookRentalTransactionDTO> findTransactionsByBookId(Long bookId) {
        return bookRentalTransactionRepository.findTransactionsByBookId(bookId)
                .stream()
                .map(BookRentalTransactionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
