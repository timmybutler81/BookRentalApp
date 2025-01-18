package com.butlert.bookrentalapp.dto.book;

import com.butlert.bookrentalapp.db.entity.book.BookStatus;
import jakarta.validation.constraints.NotBlank;

public class BookLicenseDTO {

    private Long id;
    private BookDTO book;
    private BookStatusDTO bookStatusDTO;

    @NotBlank(message = "Book Status ID cannot be blank")
    private Long bookStatusId;

    @NotBlank(message = "License Key cannot be blank")
    private String licenseKey;

    private boolean activeFlag;
    private boolean available;

    public BookLicenseDTO() {
    }

    public BookLicenseDTO(Long id, BookDTO book, BookStatusDTO bookStatusDTO, Long bookStatusId, String licenseKey, boolean activeFlag, boolean available) {
        this.id = id;
        this.book = book;
        this.bookStatusDTO = bookStatusDTO;
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

    public BookStatusDTO getBookStatus() {
        return bookStatusDTO;
    }

    public void setBookStatus(BookStatusDTO bookStatusDTO) {
        this.bookStatusDTO = bookStatusDTO;
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
