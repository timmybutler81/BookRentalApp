package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.rental.BookRentalTransactionDAO;
import com.butlert.bookrentalapp.dao.rental.TransactionStatusDAO;
import com.butlert.bookrentalapp.dao.user.UserDAO;
import com.butlert.bookrentalapp.db.entity.rental.BookRentalTransaction;
import com.butlert.bookrentalapp.db.mapper.rental.BookRentalTransactionMapper;
import com.butlert.bookrentalapp.db.repository.rental.BookRentalTransactionRepository;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.dto.rental.TransactionStatusDTO;
import com.butlert.bookrentalapp.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRentalTransactionDAOImp implements BookRentalTransactionDAO {

    @Autowired
    private BookRentalTransactionRepository bookRentalTransactionRepository;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private TransactionStatusDAO transactionStatusDAO;

    @Override
    public BookRentalTransactionDTO saveTransaction(BookRentalTransactionDTO transactionDTO) {
        //i couldn't find a better way to do this
        UserDTO userDTO = userDAO.findUserById(transactionDTO.getUserId());
        BookLicenseDTO bookLicenseDTO = bookLicenseDAO.findLicenseById(transactionDTO.getBookLicenseId());
        TransactionStatusDTO transactionStatusDTO = transactionStatusDAO.findTransactionStatusById(transactionDTO.getTransactionStatusId());
        BookRentalTransaction transaction = BookRentalTransactionMapper.toEntity(transactionDTO, userDTO, bookLicenseDTO, transactionStatusDTO);
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
    public BookRentalTransactionDTO findTransactionByLicenseAndUser(Long licenseId, Long userId) {
        BookRentalTransaction bookRentalTransaction = bookRentalTransactionRepository.findTransactionByLicenseAndUser(licenseId, userId);
        System.out.println("in dao impl: " + bookRentalTransaction);
        return BookRentalTransactionMapper.toDTO(bookRentalTransaction);
    }

    @Override
    public List<BookRentalTransactionDTO> findTransactionsByUserId(Long userId) {
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
