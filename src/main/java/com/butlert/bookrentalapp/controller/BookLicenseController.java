package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.BookLicenseDTO;
import com.butlert.bookrentalapp.service.BookLicenseService;
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
        BookLicenseDTO createdLicense = bookLicenseService.addLicenseToBook(
                bookLicenseDTO.getId(), bookLicenseDTO.getLicenseKey(), bookLicenseDTO.getBookStatusId(), bookLicenseDTO.isActiveFlag(), bookLicenseDTO.isAvailable());
        return ResponseEntity.ok(createdLicense);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<List<BookLicenseDTO>> getLicensesForBook(@PathVariable Long bookId) {
        List<BookLicenseDTO> licenses = bookLicenseService.getLicensesForBook(bookId);
        return ResponseEntity.ok(licenses);
    }
}
