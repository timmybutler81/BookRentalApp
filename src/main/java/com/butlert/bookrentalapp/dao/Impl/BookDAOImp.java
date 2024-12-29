package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.BookDAO;
import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.db.mapper.BookMapper;
import com.butlert.bookrentalapp.db.repository.BookRepository;
import com.butlert.bookrentalapp.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDAOImp implements BookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public BookDTO saveBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return BookMapper.toDTO(savedBook);
    }

    public List<BookDTO> findBooksByTitleKeyword(String keyword) {
        return bookRepository.searchBooksByTitleKeyword(keyword)
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> findBookByGenre(String genre) {
        return bookRepository.findBookByGenre(genre)
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
