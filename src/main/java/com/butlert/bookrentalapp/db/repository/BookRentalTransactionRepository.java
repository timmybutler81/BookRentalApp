package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.BookRentalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRentalTransactionRepository extends JpaRepository<BookRentalTransaction, Long> {
    List<BookRentalTransaction> findByBookLicenseId(Long bookLicenseId);

    List<BookRentalTransaction> findByBookLicenseBookId(Long bookId);
}
