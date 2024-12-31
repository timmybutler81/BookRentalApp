package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.book.BookDAO;
import com.butlert.bookrentalapp.db.entity.book.Book;
import com.butlert.bookrentalapp.db.mapper.book.BookMapper;
import com.butlert.bookrentalapp.db.repository.book.BookRepository;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDAOImp implements BookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return BookMapper.toDTO(savedBook);
    }

    @Override
    public BookDTO findBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return BookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre)
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> searchBooksByKeyword(String keyword) {
        return bookRepository.searchBooksByKeyword(keyword)
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
