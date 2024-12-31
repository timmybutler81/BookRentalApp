package com.butlert.bookrentalapp.dto;

import com.butlert.bookrentalapp.dto.user.UserDTO;

public class WaitlistUserDTO {
    private Long waitlistId;
    private Long userId;
    private WaitlistDTO waitlistDTO;
    private UserDTO userDTO;

    public WaitlistUserDTO() {
    }

    public WaitlistUserDTO(Long waitlistId, Long userId, WaitlistDTO waitlistDTO, UserDTO userDTO) {
        this.waitlistId = waitlistId;
        this.userId = userId;
        this.waitlistDTO = waitlistDTO;
        this.userDTO = userDTO;
    }

    public Long getWaitlistId() {
        return waitlistId;
    }

    public void setWaitlistId(Long waitlistId) {
        this.waitlistId = waitlistId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public WaitlistDTO getWaitlistDTO() {
        return waitlistDTO;
    }

    public void setWaitlistDTO(WaitlistDTO waitlistDTO) {
        this.waitlistDTO = waitlistDTO;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
