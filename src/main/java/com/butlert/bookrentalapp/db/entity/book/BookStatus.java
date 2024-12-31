package com.butlert.bookrentalapp.db.entity.book;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "book_status")
public class BookStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_STATUS_ID")
    private Long id;

    @Column(name = "BOOK_STATUS_NAME")
    private String bookStatusName;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanConverter.class)
    private boolean activeFlag;

    public BookStatus() {
    }

    public BookStatus(Long id, String bookStatusName, boolean activeFlag) {
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
