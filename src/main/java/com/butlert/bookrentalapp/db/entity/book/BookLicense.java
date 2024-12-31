package com.butlert.bookrentalapp.db.entity.book;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "book_license")
public class BookLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_LICENSE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "BOOK_STATUS_ID", referencedColumnName = "BOOK_STATUS_ID")
    private BookStatus bookStatus;

    @Column(name = "LICENSE_KEY", unique = true, nullable = false)
    private String licenseKey;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanConverter.class)
    private boolean activeFlag;

    @Column(name = "AVAILABLE")
    @Convert(converter = BooleanConverter.class)
    private boolean available;

    public BookLicense() {
    }

    public BookLicense(Book book, BookStatus bookStatus, String licenseKey, boolean activeFlag, boolean available) {
        this.book = book;
        this.bookStatus = bookStatus;
        this.licenseKey = licenseKey;
        this.activeFlag = activeFlag;
        this.available = available;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
