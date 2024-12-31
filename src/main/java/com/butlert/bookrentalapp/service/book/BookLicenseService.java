package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.dao.book.BookDAO;
import com.butlert.bookrentalapp.dao.book.BookLicenseDAO;
import com.butlert.bookrentalapp.dao.book.BookStatusDAO;
import com.butlert.bookrentalapp.db.mapper.book.BookStatusMapper;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
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

    public BookLicenseDTO addOrUpdateLicenseToBook(Long bookId, String licenseKey, Long statusId, boolean activeFlag, boolean available) {
        //validate inputs
        BookLicenseDTO bookLicenseDTO = new BookLicenseDTO();
        bookLicenseDTO.setId(bookId);
        bookLicenseDTO.setLicenseKey(licenseKey);
        bookLicenseDTO.setBookStatusId(statusId);
        bookLicenseDTO.setActiveFlag(activeFlag);
        bookLicenseDTO.setAvailable(available);
        validatorImp.validate(bookLicenseDTO);

        //set book license
        BookDTO bookDTO = bookDAO.findBookById(bookId);
        BookLicenseDTO savedBookLicenseDTO = new BookLicenseDTO();
        savedBookLicenseDTO.setLicenseKey(licenseKey);
        savedBookLicenseDTO.setBook(bookDTO);
        savedBookLicenseDTO.setActiveFlag(activeFlag);
        savedBookLicenseDTO.setAvailable(available);
        savedBookLicenseDTO.setBookStatus(
                BookStatusMapper.toEntity(bookStatusDAO.findBookStatusById(statusId)));

        return bookLicenseDAO.saveBookLicense(savedBookLicenseDTO);
    }

    public BookLicenseDTO getBookLicenseById(Long id) {
        return bookLicenseDAO.findLicenseById(id);
    }

    public List<BookLicenseDTO> getAllBookLicenses() {
        return bookLicenseDAO.findAllBookLicenses();
    }

    public List<BookLicenseDTO> getLicensesForBook(Long bookId) {
        return bookLicenseDAO.findLicensesByBookId(bookId);
    }
}
