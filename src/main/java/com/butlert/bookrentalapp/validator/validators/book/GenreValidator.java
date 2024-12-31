package com.butlert.bookrentalapp.validator.validators.book;

import com.butlert.bookrentalapp.dto.book.GenreDTO;
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
            throw new IllegalArgumentException("Genre must not exceed 100 characters");
        }
        if (!genreDTO.isActiveFlag() && !genreDTO.isActiveFlag()) {
            throw new IllegalArgumentException("Active Flag must be true or false");
        }
    }
}
