package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.BookStatusDTO;
import com.butlert.bookrentalapp.service.BookStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-status")
public class BookStatusController {

    @Autowired
    private BookStatusService bookStatusService;

    @GetMapping
    public List<BookStatusDTO> getAllBookStatuses() {
        return bookStatusService.getAllBookStatuses();
    }

    @GetMapping("/{id}")
    public BookStatusDTO getBookStatusById(@PathVariable Long id) {
        return bookStatusService.getBookStatusById(id);
    }

    @PostMapping("/add")
    public BookStatusDTO saveBookStatus(@RequestBody BookStatusDTO bookStatusDTO) {
        return bookStatusService.saveBookStatus(bookStatusDTO);
    }
}
