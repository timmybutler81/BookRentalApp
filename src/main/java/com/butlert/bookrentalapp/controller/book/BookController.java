package com.butlert.bookrentalapp.controller.book;

import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.service.book.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public BookDTO addBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/genre/{genre}")
    public List<BookDTO> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }
}