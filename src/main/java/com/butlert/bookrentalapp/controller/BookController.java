package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.BookDTO;
import com.butlert.bookrentalapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/add")
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @GetMapping("/search-title")
    public List<BookDTO> searchBooksByKeyword(@RequestParam String keyword) {
        return bookService.searchBooksByTitleKeyword(keyword);
    }

    @GetMapping("/search-genre")
    public List<BookDTO> findBooksByGenre(@RequestParam String genre) {
        return bookService.findBooksByGenre(genre);
    }
}
