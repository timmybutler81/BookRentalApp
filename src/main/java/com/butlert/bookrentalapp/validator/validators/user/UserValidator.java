package com.butlert.bookrentalapp.validator.validators.user;

import com.butlert.bookrentalapp.dto.user.UserDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class UserValidator implements BaseValidator<UserDTO> {

    //Don't judge my regex Jacob!!
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    @Override
    public void validate(UserDTO userDTO) {
        if (userDTO.getFirstName() == null || userDTO.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name must not be empty or null");
        }

        if (userDTO.getLastName() == null || userDTO.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name must not be empty or null");
        }

        if (userDTO.getEmailAddress() == null || userDTO.getEmailAddress().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }

        if (!isEmailValid(userDTO.getEmailAddress())) {
            throw new IllegalArgumentException("Invalid Email Format");
        }
    }

    private boolean isEmailValid(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }
}
