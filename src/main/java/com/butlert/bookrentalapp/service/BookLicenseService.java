package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookDAO;
import com.butlert.bookrentalapp.dao.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.BookStatusDAO;
import com.butlert.bookrentalapp.db.mapper.BookStatusMapper;
import com.butlert.bookrentalapp.dto.BookDTO;
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
    private BookLicenseDAO bookLicenseDAO;

    @Autowired
    private BookStatusDAO bookStatusDAO;

    @Autowired
    private BookDAO bookDAO;

    public BookLicenseDTO addLicenseToBook(Long bookId, String licenseKey, Long statusId, boolean activeFlag, boolean available) {
        //validate inputs
        BookLicenseDTO bookLicenseDTO = new BookLicenseDTO();
        bookLicenseDTO.setId(bookId);
        bookLicenseDTO.setLicenseKey(licenseKey);
        bookLicenseDTO.setBookStatusId(statusId);
        bookLicenseDTO.setActiveFlag(activeFlag);
        bookLicenseDTO.setAvailable(available);
        validatorImp.validate(bookLicenseDTO);

        BookDTO bookDTO = bookDAO.findBookById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        //set book license
        BookLicenseDTO savedBookLicenseDTO = new BookLicenseDTO();
        savedBookLicenseDTO.setLicenseKey(licenseKey);
        savedBookLicenseDTO.setBook(bookDTO);
        savedBookLicenseDTO.setActiveFlag(activeFlag);
        savedBookLicenseDTO.setAvailable(available);
        savedBookLicenseDTO.setBookStatus(
                BookStatusMapper.toEntity(bookStatusDAO.findBookStatusById(statusId)));

        return bookLicenseDAO.saveBookLicense(savedBookLicenseDTO);
    }

    public List<BookLicenseDTO> getLicensesForBook(Long bookId) {
        return bookLicenseDAO.findLicensesByBookId(bookId);
    }
}
