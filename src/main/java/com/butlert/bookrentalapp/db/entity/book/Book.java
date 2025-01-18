package com.butlert.bookrentalapp.db.entity.book;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private Long id;

    @Column(name = "GENRE_ID")
    private String genre;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "AUTHOR", nullable = false)
    private String author;

    @Column(name = "ISBN", unique = true, nullable = false)
    private String isbn;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "PUBLISH_YEAR")
    private Integer publishYear;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanConverter.class)
    private boolean activeFlag;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookLicense> licenses = new ArrayList<>();

    public Book() {

    }

    public Book(Long id, String genre, String title, String author, String isbn, String publisher, Integer publishYear, boolean activeFlag) {
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

    public List<BookLicense> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<BookLicense> licenses) {
        this.licenses = licenses;
    }

    public void addLicense(BookLicense license) {
        licenses.add(license);
        license.setBook(this);
    }

    public void removeLicense(BookLicense license) {
        licenses.remove(license);
        license.setBook(null);
    }
}
