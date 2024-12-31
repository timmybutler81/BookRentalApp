package com.butlert.bookrentalapp.db.repository.book;

import com.butlert.bookrentalapp.db.entity.book.BookLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLicenseRepository extends JpaRepository<BookLicense, Long> {
    List<BookLicense> findByBookId(Long bookId);

    @Query(value = "SELECT CASE WHEN EXISTS(SELECT 1 FROM book_license WHERE available = 'Y' AND active_flag = 'Y' AND book_id = :bookId) THEN TRUE ELSE FALSE END", nativeQuery = true)
    boolean findAvailabilityByBookId(@Param("bookId") Long bookId);
}
