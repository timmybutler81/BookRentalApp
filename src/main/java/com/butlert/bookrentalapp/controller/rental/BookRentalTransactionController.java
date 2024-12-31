package com.butlert.bookrentalapp.controller.rental;

import com.butlert.bookrentalapp.dto.rental.BookRentalTransactionDTO;
import com.butlert.bookrentalapp.service.rental.BookRentalService;
import com.butlert.bookrentalapp.service.rental.BookRentalTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class BookRentalTransactionController {

    @Autowired
    private BookRentalTransactionService bookRentalTransactionService;

    @Autowired
    private BookRentalService bookRentalService;

    @PostMapping("/checkout")
    public ResponseEntity<BookRentalTransactionDTO> checkOutBook(
                                                @RequestParam Long bookLicenseId,
                                                @RequestParam Long userId) {
        BookRentalTransactionDTO bookRentalTransactionDTO = bookRentalService.checkoutBook(bookLicenseId, userId);
        return ResponseEntity.ok(bookRentalTransactionDTO);
    }

    @PostMapping("/return")
    public ResponseEntity<BookRentalTransactionDTO> returnBook(
                                                @RequestParam Long bookLicenseId,
                                                @RequestParam Long userId) {
        BookRentalTransactionDTO bookRentalTransactionDTO = bookRentalService.returnBook(bookLicenseId, userId);
        return ResponseEntity.ok(bookRentalTransactionDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookRentalTransactionDTO> getBookRentalTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(bookRentalTransactionService.getBookRentalTransactionById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookRentalTransactionDTO>> getAllBookRentalTransactions() {
        return ResponseEntity.ok(bookRentalTransactionService.getAllBookRentalTransactions());
    }

    @GetMapping("/book-license")
    public ResponseEntity<List<BookRentalTransactionDTO>> getTransactionByBookLicenseId(@RequestParam Long bookLicenseId) {
        return ResponseEntity.ok(bookRentalTransactionService.getTransactionByBookLicenseId(bookLicenseId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookRentalTransactionDTO>> getTransactionsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(bookRentalTransactionService.getTransactionsByUserId(userId));
    }
}
