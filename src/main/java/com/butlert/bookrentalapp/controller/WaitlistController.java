package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.WaitlistDTO;
import com.butlert.bookrentalapp.dto.WaitlistUserDTO;
import com.butlert.bookrentalapp.dto.book.BookDetailsWithWaitTimeDTO;
import com.butlert.bookrentalapp.service.WaitlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waitlist")
public class WaitlistController {

    @Autowired
    private WaitlistService waitlistService;

    @PostMapping("/add")
    public ResponseEntity<WaitlistDTO> addUserToWaitlist(@RequestParam Long bookId, @RequestParam Long userId) {
        return ResponseEntity.ok(waitlistService.addUserToWaitlist(bookId, userId));
    }

    @PostMapping("/remove")
    public void removeUserFromWaitlist(@RequestParam Long bookId, @RequestParam Long userId) {
        waitlistService.removeUserFromWaitlist(bookId, userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<WaitlistUserDTO>> getWaitlistByUser(@PathVariable Long id) {
        return ResponseEntity.ok(waitlistService.getWaitlistByUser(id));
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<List<WaitlistDTO>> getWaitlistByBookId(Long bookId) {
        return ResponseEntity.ok(waitlistService.getWaitlistByBookId(bookId));
    }

    @GetMapping("/time-remaining")
    public ResponseEntity<BookDetailsWithWaitTimeDTO> getBookDetailsWithWaitTime(@RequestParam Long bookId, @RequestParam Long userId) {
        return ResponseEntity.ok(waitlistService.getBookDetailsWithWaitTime(bookId, userId));
    }
}
