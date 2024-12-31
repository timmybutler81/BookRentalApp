package com.butlert.bookrentalapp.db.repository.rental;

import com.butlert.bookrentalapp.db.entity.rental.BookRentalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRentalTransactionRepository extends JpaRepository<BookRentalTransaction, Long> {
    List<BookRentalTransaction> findTransactionByBookLicenseId(Long bookLicenseId);

    @Query(value = "SELECT * FROM book_rental_transaction WHERE date_returned = null and book_license_id = :licenseId and user_id = :userId", nativeQuery = true)
    BookRentalTransaction findTransactionByLicenseAndUser(@Param("licenseId") Long licenseId, @Param("userId") Long userId);

    @Query(value = "SELECT * FROM book_rental_transaction WHERE user_id = :userId", nativeQuery = true)
    List<BookRentalTransaction> findTransactionsByUserId(@Param("userId") Long userId);
}
