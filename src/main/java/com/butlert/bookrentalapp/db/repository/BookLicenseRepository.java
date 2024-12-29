package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.BookLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookLicenseRepository extends JpaRepository<BookLicense, Long> {
    List<BookLicense> findByBookId(Long bookId);

    Optional<BookLicense> findByBookIdAndBookStatusBookStatusName(Long bookId, String bookStatusName);
}
