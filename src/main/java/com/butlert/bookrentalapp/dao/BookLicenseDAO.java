package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.dto.BookLicenseDTO;

import java.util.List;

public interface BookLicenseDAO {
    BookLicenseDTO saveBookLicense(BookLicenseDTO bookLicenseDTO);

    List<BookLicenseDTO> findLicensesByBookId(Long bookId);

    BookLicenseDTO updateLicenseStatus(Long licenseId, Long statusId);

    BookLicenseDTO findLicenseById(Long bookLicenseId);

    boolean findAvailabilityByBookId(Long bookId);

    void updateLicenseAvailability(Long bookLicenseId, boolean available);
}
