package com.butlert.bookrentalapp.db.entity.user;

import com.butlert.bookrentalapp.utils.BooleanConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_TYPE_ID")
    private Long id;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @Column(name = "RENTAL_DURATION_DAYS")
    private int rentalDurationDays;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanConverter.class)
    private boolean activeFlag;

    public UserType() {
    }

    public UserType(Long id, String typeName, int rentalDurationDays, boolean activeFlag) {
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
