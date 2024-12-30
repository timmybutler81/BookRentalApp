package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.BookLicenseDAO;
import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.db.mapper.BookLicenseMapper;
import com.butlert.bookrentalapp.db.mapper.BookStatusMapper;
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
    public BookLicenseDTO saveBookLicense(BookLicenseDTO bookLicenseDTO) {
        BookLicense savedLicense = bookLicenseRepository.save(BookLicenseMapper.toEntity(bookLicenseDTO));
        return BookLicenseMapper.toDTO(savedLicense);
    }

    @Override
    public List<BookLicenseDTO> findLicensesByBookId(Long bookId) {
        List<BookLicense> licenses = bookLicenseRepository.findByBookId(bookId);
        return licenses.stream()
                .map(BookLicenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookLicenseDTO findLicenseById(Long id) {
        BookLicense bookLicense = bookLicenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book Status not found"));
        return BookLicenseMapper.toDTO(bookLicense);
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
    public void updateLicenseAvailability(Long bookLicenseId, boolean available) {
        BookLicense bookLicense = bookLicenseRepository.findById(bookLicenseId)
                .orElseThrow(() -> new RuntimeException("Book License not found"));
        bookLicense.setAvailable(available);
        bookLicenseRepository.save(bookLicense);
    }

    @Override
    public boolean findAvailabilityByBookId(Long bookId) {
        return bookLicenseRepository.findAvailabilityByBookId(bookId);
    }
}
