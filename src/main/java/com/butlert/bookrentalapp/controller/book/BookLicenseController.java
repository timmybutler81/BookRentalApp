package com.butlert.bookrentalapp.controller.book;

import com.butlert.bookrentalapp.dto.book.BookLicenseDTO;
import com.butlert.bookrentalapp.service.book.BookLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-license")
public class BookLicenseController {

    @Autowired
    private BookLicenseService bookLicenseService;

    @PostMapping("/add")
    public ResponseEntity<BookLicenseDTO> addLicenseToBook(@RequestBody BookLicenseDTO bookLicenseDTO) {
        return ResponseEntity.ok(bookLicenseService.addLicenseToBook(bookLicenseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookLicenseDTO> getBookLicenseById(@PathVariable Long id) {
        return ResponseEntity.ok(bookLicenseService.getBookLicenseById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookLicenseDTO>> getAllBookLicenses() {
        return ResponseEntity.ok(bookLicenseService.getAllBookLicenses());
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BookLicenseDTO>> getLicensesForBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(bookLicenseService.getLicensesForBook(bookId));
    }
}
