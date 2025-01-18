package com.butlert.bookrentalapp.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookDTO {

    private Long id;

    @NotBlank(message = "Genre cannot be blank")
    @Size(max = 100, message = "Genre must not exceed 100 characters")
    private String genre;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Size(max = 100, message = "Author must not exceed 100 characters")
    private String author;

    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;

    @NotBlank(message = "Publisher cannot be blank")
    @Size(max = 100, message = "Publisher must not exceed 100 characters")
    private String publisher;

    @NotNull(message = "Publish Year cannot be null")
    private Integer publishYear;

    private boolean activeFlag;

    // Constructors, Getters, and Setters
    public BookDTO() {
    }

    public BookDTO(Long id, String genre, String title, String author, String isbn, String publisher, Integer publishYear, boolean activeFlag) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}