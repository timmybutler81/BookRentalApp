package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.BookDAO;
import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.repository.BookRepository;
import com.butlert.bookrentalapp.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDAO bookDAO;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
        }
        return null;
    }

    public List<Book> searchBookByTitleKeyword(String keyword) {
        return bookDAO.findBookByTitleKeyword(keyword);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    //TODO update methods, entity, repository with new structure
    //TODO change active_flag method
}
