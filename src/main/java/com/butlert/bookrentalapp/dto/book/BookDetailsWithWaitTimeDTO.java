package com.butlert.bookrentalapp.dto.book;

public class BookDetailsWithWaitTimeDTO {
    private BookDTO book;
    private int estimatedWaitDays;

    // Constructors, getters, and setters
    public BookDetailsWithWaitTimeDTO(BookDTO book, int estimatedWaitDays) {
        this.book = book;
        this.estimatedWaitDays = estimatedWaitDays;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public int getEstimatedWaitDays() {
        return estimatedWaitDays;
    }

    public void setEstimatedWaitDays(int estimatedWaitDays) {
        this.estimatedWaitDays = estimatedWaitDays;
    }
}