package com.butlert.bookrentalapp.dto;

import java.time.LocalDate;

public class WaitlistDTO {

    private Long id;
    private Long bookId;
    private Long userId;
    private String waitlistStatus;
    private LocalDate waitlistAddDate;
    private boolean processedFlag;

    public WaitlistDTO() {
    }

    public WaitlistDTO(Long id, Long bookId, Long userId, String waitlistStatus, LocalDate waitlistAddDate, boolean processedFlag) {
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
