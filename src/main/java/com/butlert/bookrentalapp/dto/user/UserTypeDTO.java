package com.butlert.bookrentalapp.dto.user;

public class UserTypeDTO {

    private Long id;
    private String typeName;
    private int rentalDurationDays;
    private boolean activeFlag;

    public UserTypeDTO() {
    }

    public UserTypeDTO(Long id, String typeName, int rentalDurationDays, boolean activeFlag) {
        this.id = id;
        this.typeName = typeName;
        this.rentalDurationDays = rentalDurationDays;
        this.activeFlag = activeFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getRentalDurationDays() {
        return rentalDurationDays;
    }

    public void setRentalDurationDays(int rentalDurationDays) {
        this.rentalDurationDays = rentalDurationDays;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }
}
