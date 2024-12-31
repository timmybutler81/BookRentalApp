package com.butlert.bookrentalapp.db.mapper.user;

import com.butlert.bookrentalapp.db.entity.user.User;
import com.butlert.bookrentalapp.dto.user.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUserType(), user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhoneNumber(), user.getRegistrationDate(),
                user.isActiveFlag());
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserType(userDTO.getUserType());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRegistrationDate(userDTO.getRegistrationDate());
        user.setActiveFlag(userDTO.isActiveFlag());
        return user;
    }
}
