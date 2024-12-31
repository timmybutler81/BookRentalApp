package com.butlert.bookrentalapp.validator.validators.user;

import com.butlert.bookrentalapp.dto.user.UserTypeDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class UserTypeValidator implements BaseValidator<UserTypeDTO> {

    @Override
    public void validate(UserTypeDTO userTypeDTO) {
        if (userTypeDTO.getTypeName() == null || userTypeDTO.getTypeName().isEmpty()) {
            throw new IllegalArgumentException("User Type name must not be empty or null");
        }
        if (userTypeDTO.getTypeName().length() > 100) {
            throw new IllegalArgumentException("User Type name must not exceed 100 characters");
        }
        if (!userTypeDTO.isActiveFlag() && !userTypeDTO.isActiveFlag()) {
            throw new IllegalArgumentException("Active Flag must be true or false");
        }
        if (userTypeDTO.getRentalDurationDays() < 0) {
            throw new IllegalArgumentException("Rental Duration Days cannot be negative");
        }
    }
}
