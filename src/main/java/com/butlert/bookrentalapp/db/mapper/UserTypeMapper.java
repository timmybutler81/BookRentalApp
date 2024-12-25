package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.UserType;
import com.butlert.bookrentalapp.dto.UserTypeDTO;

public class UserTypeMapper {

    public static UserTypeDTO toDTO(UserType userType) {
        return new UserTypeDTO(
                userType.getId(),
                userType.getTypeName(),
                userType.getRentalDurationDays(),
                userType.isActiveFlag());
    }

    public static UserType toEntity(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType();
        userType.setId(userTypeDTO.getId());
        userType.setTypeName(userTypeDTO.getTypeName());
        userType.setRentalDurationDays(userTypeDTO.getRentalDurationDays());
        userType.setActiveFlag(userTypeDTO.isActiveFlag());
        return userType;
    }
}
