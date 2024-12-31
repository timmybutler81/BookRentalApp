package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.db.entity.book.BookLicense;
import com.butlert.bookrentalapp.db.mapper.book.BookLicenseMapper;
import com.butlert.bookrentalapp.db.repository.book.BookLicenseRepository;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookLicenseDAOImp implements BookLicenseDAO {

    @Autowired
    private BookLicenseRepository bookLicenseRepository;

    @Override
    public BookLicenseDTO saveBookLicense(BookLicenseDTO bookLicenseDTO) {
        BookLicense bookLicense = BookLicenseMapper.toEntity(bookLicenseDTO);
        BookLicense savedBookLicense = bookLicenseRepository.save(bookLicense);
        return BookLicenseMapper.toDTO(savedBookLicense);
    }

    @Override
    public BookLicenseDTO findLicenseById(Long id) {
        BookLicense bookLicense = bookLicenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book License not found"));
        return BookLicenseMapper.toDTO(bookLicense);
    }

    @Override
    public List<BookLicenseDTO> findAllBookLicenses() {
        return bookLicenseRepository.findAll()
                .stream()
                .map(BookLicenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookLicenseDTO> findLicensesByBookId(Long bookId) {
        return bookLicenseRepository.findByBookId(bookId)
                .stream()
                .map(BookLicenseMapper::toDTO)
                .collect(Collectors.toList());
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

    public Optional<BookLicenseDTO> findAvailableLicenseByBookId(Long bookId) {
        return bookLicenseRepository.findByBookId(bookId)
                .stream()
                .map(BookLicenseMapper::toDTO)
                .filter(BookLicenseDTO::isAvailable)
                .findFirst();
    }
}
