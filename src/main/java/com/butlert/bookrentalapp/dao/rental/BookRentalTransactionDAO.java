package com.butlert.bookrentalapp.dao.rental;

import com.butlert.bookrentalapp.db.entity.rental.BookRentalTransaction;
import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;

import java.util.List;
import java.util.Optional;

public interface BookRentalTransactionDAO {
    BookRentalTransactionDTO saveTransaction(BookRentalTransactionDTO transactionDTO);

    BookRentalTransactionDTO findBookRentalTransactionById(Long id);

    List<BookRentalTransactionDTO> findAllBookRentalTransactions();

    List<BookRentalTransactionDTO> findTransactionByBookLicenseId(Long bookLicenseId);

    BookRentalTransactionDTO findTransactionByLicenseAndUser(Long licenseId, Long userId);

    List<BookRentalTransactionDTO> findTransactionsByUserId (Long userId);

    List<BookRentalTransactionDTO> findTransactionsByBookId(Long bookId);
}
