package com.butlert.bookrentalapp.db.entity.rental;

import com.butlert.bookrentalapp.db.entity.book.BookLicense;
import com.butlert.bookrentalapp.db.entity.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BOOK_RENTAL_TRANSACTION")
public class BookRentalTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "BOOK_LICENSE_ID", nullable = false)
    private BookLicense bookLicense;

    @ManyToOne
    @JoinColumn(name = "TRANSACTION_STATUS_ID", nullable = false)
    private TransactionStatus transactionStatus;

    @Column(name = "CHECK_OUT_DATE", nullable = false)
    private LocalDate checkOutDate;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "DATE_RETURNED")
    private LocalDate dateReturned;

    public BookRentalTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookLicense getBookLicense() {
        return bookLicense;
    }

    public void setBookLicense(BookLicense bookLicense) {
        this.bookLicense = bookLicense;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
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
