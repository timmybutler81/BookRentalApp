package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.dto.BookLicenseDTO;

import java.util.List;

public interface BookLicenseDAO {
    BookLicenseDTO saveBookLicense(BookLicense bookLicense);

    List<BookLicenseDTO> findLicensesByBookId(Long bookId);

    BookLicenseDTO updateLicenseStatus(Long licenseId, Long statusId);

    BookLicense findLicenseById(Long bookLicenseId);

    BookLicense findAvailableLicenseByBookId(Long bookId);
}
