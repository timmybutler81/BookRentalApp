package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.BookLicenseDAO;
import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.db.mapper.BookLicenseMapper;
import com.butlert.bookrentalapp.db.repository.BookLicenseRepository;
import com.butlert.bookrentalapp.db.repository.BookStatusRepository;
import com.butlert.bookrentalapp.dto.BookLicenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookLicenseDAOImp implements BookLicenseDAO {

    @Autowired
    private BookLicenseRepository bookLicenseRepository;

    @Autowired
    private BookStatusRepository bookStatusRepository;

    @Override
    public BookLicenseDTO saveBookLicense(BookLicense bookLicense) {
        BookLicense savedLicense = bookLicenseRepository.save(bookLicense);
        return BookLicenseMapper.toDTO(savedLicense);
    }

    @Override
    public List<BookLicenseDTO> findLicensesByBookId(Long bookId) {
        List<BookLicense> licenses = bookLicenseRepository.findByBookId(bookId);
        return licenses.stream()
                .map(BookLicenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookLicense findLicenseById(Long bookLicenseId) {
        return bookLicenseRepository.findById(bookLicenseId)
                .orElseThrow(() -> new RuntimeException("Book License not found for ID: " + bookLicenseId));
    }

    @Override
    public BookLicenseDTO updateLicenseStatus(Long licenseId, Long statusId) {
        //verify license and status exist
        BookLicense bookLicense = bookLicenseRepository.findById(licenseId)
                .orElseThrow(() -> new RuntimeException("License not found"));

        BookStatus bookStatus = bookStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        bookLicense.setBookStatus(bookStatus);
        BookLicense updatedLicense = bookLicenseRepository.save(bookLicense);

        return BookLicenseMapper.toDTO(updatedLicense);
    }

    @Override
    public BookLicense findAvailableLicenseByBookId(Long bookId) {
        return bookLicenseRepository.findByBookIdAndBookStatusBookStatusName(bookId, "Available")
                .orElseThrow(() -> new RuntimeException("No available licenses for book ID: " + bookId));
    }
}
