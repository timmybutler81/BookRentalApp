package com.butlert.bookrentalapp.dto;

public class BookDTO {
    private long id;
    private String title;
    private String author;

    public BookDTO() {
    }

    public BookDTO(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}