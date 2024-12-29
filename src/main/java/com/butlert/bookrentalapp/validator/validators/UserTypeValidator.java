package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.UserTypeDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class UserTypeValidator implements BaseValidator<UserTypeDTO> {

    @Override
    public void validate(UserTypeDTO userTypeDTO) {
        if (userTypeDTO.getTypeName() == null || userTypeDTO.getTypeName().isEmpty()) {
            throw new IllegalArgumentException("Transaction Type name must not be empty or null");
        }

        if (userTypeDTO.getTypeName().length() > 100) {
            throw new IllegalArgumentException("Transaction Type  name must less than 100 characters");
        }

        if (userTypeDTO.getRentalDurationDays() < 0) {
            throw new IllegalArgumentException("Rental Duration Days cannot be negative");
        }
    }
}
