package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.db.entity.book.Book;
import com.butlert.bookrentalapp.db.mapper.book.BookMapper;
import com.butlert.bookrentalapp.db.repository.book.BookRepository;
import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.utils.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        return BookMapper.toDTO(bookRepository.save(BookMapper.toEntity(bookDTO)));
    }

    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BookDTO> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre)
                .stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO getBookEntityById(Long id) {
        return bookRepository.findById(id)
                .map(BookMapper::toDTO)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
    }
}