package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookDAO;
import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.mapper.BookMapper;
import com.butlert.bookrentalapp.db.repository.BookRepository;
import com.butlert.bookrentalapp.dto.BookDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> findAllBooks() {
        return bookDAO.findAllBooks();
    }

    public Optional<BookDTO> getBookById(Long id) {
        return bookDAO.findBookById(id);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        validatorImp.validate(bookDTO);
        Book book = BookMapper.toEntity(bookDTO);
        return bookDAO.saveBook(book);
    }

    public List<BookDTO> searchBooksByTitleKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword must not be empty or null");
        }
        return bookDAO.findBooksByTitleKeyword(keyword);
    }

    public List<BookDTO> findBooksByGenre(String genre) {
        if (genre == null || genre.isEmpty()) {
            throw new IllegalArgumentException("Keyword must not be empty or null");
        }
        return bookDAO.findBookByGenre(genre);
    }
}
