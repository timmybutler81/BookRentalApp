package com.butlert.bookrentalapp.dto.rental;

import java.time.LocalDate;

public class BookRentalTransactionDTO {
    private Long id;
    private Long userId;
    private Long bookLicenseId;
    private Long transactionStatusId;
    private LocalDate checkOutDate;
    private LocalDate dueDate;
    private LocalDate dateReturned;

    public BookRentalTransactionDTO() {
    }

    public BookRentalTransactionDTO(Long id, Long userId, Long bookLicenseId, Long transactionStatusId, LocalDate checkOutDate, LocalDate dueDate, LocalDate dateReturned) {
        this.id = id;
        this.userId = userId;
        this.bookLicenseId = bookLicenseId;
        this.transactionStatusId = transactionStatusId;
        this.checkOutDate = checkOutDate;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookLicenseId() {
        return bookLicenseId;
    }

    public void setBookLicenseId(Long bookLicenseId) {
        this.bookLicenseId = bookLicenseId;
    }

    public Long getTransactionStatusId() {
        return transactionStatusId;
    }

    public void setTransactionStatusId(Long transactionStatusId) {
        this.transactionStatusId = transactionStatusId;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }
}
