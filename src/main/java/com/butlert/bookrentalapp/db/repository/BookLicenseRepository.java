package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.entity.BookLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookLicenseRepository extends JpaRepository<BookLicense, Long> {
    List<BookLicense> findByBookId(Long bookId);

    Optional<BookLicense> findByBookIdAndBookStatusBookStatusName(Long bookId, String bookStatusName);

    @Query(value = "SELECT EXISTS(SELECT 1 FROM book_license WHERE available = 'Y' AND active_flag = 'Y' AND book_id = :bookId)", nativeQuery = true)
    boolean findAvailabilityByBookId(@Param("bookId") Long bookId);
}
