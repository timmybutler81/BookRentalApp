package com.butlert.bookrentalapp.db.entity;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "waitlist")
public class Waitlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WAITLIST_ID")
    private Long id;

    @Column(name = "BOOK_ID")
    private Long bookId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "WAITLIST_STATUS")
    private String waitlistStatus;

    @Column(name = "WAITLIST_ADD_DATE")
    private LocalDate waitlistAddDate;

    @Convert(converter = BooleanConverter.class)
    @Column(name = "PROCESSED_FLAG")
    private boolean processedFlag;

    public Waitlist() {
    }

    public Waitlist(Long id, Long bookId, Long userId, String waitlistStatus, LocalDate waitlistAddDate, boolean processedFlag) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.waitlistStatus = waitlistStatus;
        this.waitlistAddDate = waitlistAddDate;
        this.processedFlag = processedFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWaitlistStatus() {
        return waitlistStatus;
    }

    public void setWaitlistStatus(String waitlistStatus) {
        this.waitlistStatus = waitlistStatus;
    }

    public LocalDate getWaitlistAddDate() {
        return waitlistAddDate;
    }

    public void setWaitlistAddDate(LocalDate waitlistAddDate) {
        this.waitlistAddDate = waitlistAddDate;
    }

    public boolean isProcessedFlag() {
        return processedFlag;
    }

    public void setProcessedFlag(boolean processedFlag) {
        this.processedFlag = processedFlag;
    }
}
