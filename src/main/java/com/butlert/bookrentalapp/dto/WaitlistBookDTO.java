package com.butlert.bookrentalapp.dto;

public class WaitlistBookDTO {
    private Long waitlistId;
    private WaitlistDTO waitlistDTO;
    private int estimatedDaysUntilAvailable;

    public WaitlistBookDTO() {
    }

    public WaitlistBookDTO(Long waitlistId, WaitlistDTO waitlistDTO, int estimatedDaysUntilAvailable) {
        this.waitlistId = waitlistId;
        this.waitlistDTO = waitlistDTO;
        this.estimatedDaysUntilAvailable = estimatedDaysUntilAvailable;
    }

    public Long getWaitlistId() {
        return waitlistId;
    }

    public void setWaitlistId(Long waitlistId) {
        this.waitlistId = waitlistId;
    }

    public WaitlistDTO getWaitlistDTO() {
        return waitlistDTO;
    }

    public void setWaitlistDTO(WaitlistDTO waitlistDTO) {
        this.waitlistDTO = waitlistDTO;
    }

    public int getEstimatedDaysUntilAvailable() {
        return estimatedDaysUntilAvailable;
    }

    public void setEstimatedDaysUntilAvailable(int estimatedDaysUntilAvailable) {
        this.estimatedDaysUntilAvailable = estimatedDaysUntilAvailable;
    }
}
