package com.butlert.bookrentalapp.dto.book;

import com.butlert.bookrentalapp.db.entity.book.BookStatus;

public class BookLicenseDTO {

    private Long id;
    private BookDTO book;
    private BookStatus bookStatus;
    private Long bookStatusId;
    private String licenseKey;
    private boolean activeFlag;
    private boolean available;

    public BookLicenseDTO() {
    }

    public BookLicenseDTO(Long id, BookDTO book, BookStatus bookStatus, Long bookStatusId, String licenseKey, boolean activeFlag, boolean available) {
        this.id = id;
        this.book = book;
        this.bookStatus = bookStatus;
        this.bookStatusId = bookStatusId;
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

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
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

    public Long getBookStatusId() {
        return bookStatusId;
    }

    public void setBookStatusId(Long bookStatusId) {
        this.bookStatusId = bookStatusId;
    }
}
