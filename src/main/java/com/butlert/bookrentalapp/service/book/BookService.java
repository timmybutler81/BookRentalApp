package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.dao.book.BookDAO;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private ValidatorImp validator;

    public BookDTO addOrUpdateBook(BookDTO bookDTO) {
        validator.validate(bookDTO);
        return bookDAO.saveBook(bookDTO);
    }

    public BookDTO getBookById(Long id) {
        return bookDAO.findBookById(id);
    }

    public List<BookDTO> getAllBooks() {
        return bookDAO.findAllBooks();
    }

    public List<BookDTO> getBooksByGenre(String genre) {
        return bookDAO.findBooksByGenre(genre);
    }

    public List<BookDTO> searchBooks(String keyword) {
        return bookDAO.searchBooksByKeyword(keyword);
    }
}
