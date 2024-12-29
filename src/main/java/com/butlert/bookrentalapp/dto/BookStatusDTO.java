package com.butlert.bookrentalapp.dto;

public class BookStatusDTO {

    private Long id;
    private String bookStatusName;
    private boolean activeFlag;

    public BookStatusDTO() {
    }

    public BookStatusDTO(Long id, String bookStatusName, boolean activeFlag) {
        this.id = id;
        this.bookStatusName = bookStatusName;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookStatusName() {
        return bookStatusName;
    }

    public void setBookStatusName(String bookStatusName) {
        this.bookStatusName = bookStatusName;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
