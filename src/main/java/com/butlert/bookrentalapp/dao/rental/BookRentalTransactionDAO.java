package com.butlert.bookrentalapp.dao.rental;

import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;

import java.util.List;

public interface BookRentalTransactionDAO {
    BookRentalTransactionDTO saveTransaction(BookRentalTransactionDTO transactionDTO);

    BookRentalTransactionDTO findBookRentalTransactionById(Long id);

    List<BookRentalTransactionDTO> findAllBookRentalTransactions();

    List<BookRentalTransactionDTO> findTransactionByBookLicenseId(Long bookLicenseId);

    BookRentalTransactionDTO findTransactionByLicenseAndUser(Long licenseId, Long userId);

    List<BookRentalTransactionDTO> findTransactionsByUserId(Long userId);

    List<BookRentalTransactionDTO> findTransactionsByBookId(Long bookId);
}
