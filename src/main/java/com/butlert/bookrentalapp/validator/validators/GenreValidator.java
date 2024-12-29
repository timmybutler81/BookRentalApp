package com.butlert.bookrentalapp.validator.validators;

import com.butlert.bookrentalapp.dto.GenreDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

@Component
public class GenreValidator implements BaseValidator<GenreDTO> {

    @Override
    public void validate(GenreDTO genreDTO) {
        if (genreDTO.getGenreName() == null || genreDTO.getGenreName().isEmpty()) {
            throw new IllegalArgumentException("Genre name must not be empty or null");
        }

        if (genreDTO.getGenreName().length() > 100) {
            throw new IllegalArgumentException("Genre name must less than 100 characters");
        }
    }
}
