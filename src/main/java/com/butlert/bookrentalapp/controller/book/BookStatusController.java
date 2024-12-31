package com.butlert.bookrentalapp.controller.book;

import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
import com.butlert.bookrentalapp.service.book.BookStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-status")
public class BookStatusController {

    @Autowired
    private BookStatusService bookStatusService;

    @PostMapping
    public ResponseEntity<BookStatusDTO> addOrUpdateBookStatus(BookStatusDTO bookStatusDTO) {
        return ResponseEntity.ok(bookStatusService.addOrUpdateBookStatus(bookStatusDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookStatusDTO> getBookStatusById(@PathVariable Long id) {
        return ResponseEntity.ok(bookStatusService.getBookStatusById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookStatusDTO>> getAllBookStatuses() {
        return ResponseEntity.ok(bookStatusService.getAllBookStatuses());
    }
}
