package com.butlert.bookrentalapp.controller.book;

import com.butlert.bookrentalapp.dto.book.BookStatusDTO;
import com.butlert.bookrentalapp.service.book.BookStatusService;
import com.butlert.bookrentalapp.validator.validators.book.BookStatusValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-status")
public class BookStatusController {

    @Autowired
    private BookStatusService bookStatusService;

    private static final Logger logger = LoggerFactory.getLogger(BookStatusValidator.class);

    @PostMapping("/add")
    public ResponseEntity<BookStatusDTO> addBookStatus(@RequestBody BookStatusDTO bookStatusDTO) {
        logger.info("Book Status request add received for : {}", bookStatusDTO.getBookStatusName());
        return ResponseEntity.ok(bookStatusService.saveBookStatus(bookStatusDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookStatusDTO> getBookStatusById(@PathVariable Long id) {
        logger.info("Book Status retrieve request for ID : {}", id);
        return ResponseEntity.ok(bookStatusService.findBookStatusById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookStatusDTO>> getAllBookStatuses() {
        return ResponseEntity.ok(bookStatusService.findAllBookStatuses());
    }
}
