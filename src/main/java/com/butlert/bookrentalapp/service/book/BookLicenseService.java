package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.db.mapper.book.BookLicenseMapper;
import com.butlert.bookrentalapp.db.repository.book.BookLicenseRepository;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.utils.exceptions.BookNotFoundException;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookLicenseService {

    private final ValidatorImp validatorImp;
    private final BookLicenseRepository bookLicenseRepository;
    private final BookService bookService;

    @Autowired
    public BookLicenseService(
            ValidatorImp validatorImp,
            BookLicenseRepository bookLicenseRepository,
            BookService bookService) {
        this.validatorImp = validatorImp;
        this.bookLicenseRepository = bookLicenseRepository;
        this.bookService = bookService;
    }

    public BookLicenseDTO addLicenseToBook(BookLicenseDTO bookLicenseDTO) {
        validatorImp.validate(bookLicenseDTO);
        Long bookId = bookLicenseDTO.getBook().getId();
        BookDTO bookDTO = bookService.getBookById(bookId);
        if (bookDTO == null) {
            throw new BookNotFoundException("Book not found with ID: " + bookId);
        }
        return BookLicenseMapper.toDTO(
                bookLicenseRepository.save(
                        BookLicenseMapper.toEntity(bookLicenseDTO)
                )
        );
    }

    public BookLicenseDTO getBookLicenseById(Long id) {
        return bookLicenseRepository.findById(id)
                .map(BookLicenseMapper::toDTO)
                .orElseThrow(() -> new BookNotFoundException("Book license not found with ID: " + id));
    }

    public List<BookLicenseDTO> getAllBookLicenses() {
        return bookLicenseRepository.findAll()
                .stream()
                .map(BookLicenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BookLicenseDTO> getLicensesForBook(Long bookId) {
        bookService.getBookById(bookId);
        return bookLicenseRepository.findByBookId(bookId)
                .stream()
                .map(BookLicenseMapper::toDTO)
                .collect(Collectors.toList());
    }
}
