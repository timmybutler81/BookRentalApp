package com.butlert.bookrentalapp.dao.book;

import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;

import java.util.List;
import java.util.Optional;

public interface BookLicenseDAO {
    BookLicenseDTO saveBookLicense(BookLicenseDTO bookLicenseDTO);

    BookLicenseDTO findLicenseById(Long id);

    List<BookLicenseDTO> findAllBookLicenses();

    List<BookLicenseDTO> findLicensesByBookId(Long bookId);

    void updateLicenseAvailability(Long bookLicenseId, boolean available);

    boolean findAvailabilityByBookId(Long bookId);

    Optional<BookLicenseDTO> findAvailableLicenseByBookId(Long bookId);
}
