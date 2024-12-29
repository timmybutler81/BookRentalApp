package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookLicenseDAO;
import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.entity.BookLicense;
import com.butlert.bookrentalapp.db.repository.BookRepository;
import com.butlert.bookrentalapp.db.repository.BookStatusRepository;
import com.butlert.bookrentalapp.dto.BookLicenseDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLicenseService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private BookStatusRepository bookStatusRepository;

    public BookLicenseDTO addLicenseToBook(Long bookId, String licenseKey, Long statusId, boolean activeFlag, boolean available) {
        //validate inputs
        BookLicenseDTO bookLicenseDTO = new BookLicenseDTO();
        bookLicenseDTO.setId(bookId);
        bookLicenseDTO.setLicenseKey(licenseKey);
        bookLicenseDTO.setBookStatusId(statusId);
        bookLicenseDTO.setActiveFlag(activeFlag);
        bookLicenseDTO.setAvailable(available);
        validatorImp.validate(bookLicenseDTO);

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        //set book license
        BookLicense bookLicense = new BookLicense();
        bookLicense.setLicenseKey(licenseKey);
        bookLicense.setBook(book);
        bookLicense.setActiveFlag(activeFlag);
        bookLicense.setAvailable(available);

        bookLicense.setBookStatus(
                bookStatusRepository.findById(statusId)
                        .orElseThrow(() -> new RuntimeException("Book status not found"))
        );

        return bookLicenseDAO.saveBookLicense(bookLicense);
    }

    public List<BookLicenseDTO> getLicensesForBook(Long bookId) {
        return bookLicenseDAO.findLicensesByBookId(bookId);
    }
}
