package com.butlert.bookrentalapp.validator.validators.book;

import com.butlert.bookrentalapp.dto.book.BookDTO;
import com.butlert.bookrentalapp.validator.BaseValidator;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class BookValidator implements BaseValidator<BookDTO> {

    @Override
    public void validate(BookDTO bookDTO) {
        // Validate Title
        if (bookDTO.getTitle() == null || bookDTO.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Book Title must not be empty or null");
        }
        if (bookDTO.getTitle().length() > 100) {
            throw new IllegalArgumentException("Book Title must not exceed 100 characters");
        }

        // Validate Author
        if (bookDTO.getAuthor() == null || bookDTO.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Author name must not be empty or null");
        }
        if (bookDTO.getAuthor().length() > 100) {
            throw new IllegalArgumentException("Author name must not exceed 100 characters");
        }

        // Validate ISBN
        if (bookDTO.getIsbn() == null || bookDTO.getIsbn().trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN must not be empty or null");
        }
        if (!bookDTO.getIsbn().matches("^(97(8|9))?\\d{9}(\\d|X)$")) {
            throw new IllegalArgumentException("Invalid ISBN format. Must be 10 or 13 digits");
        }

        // Validate Publisher
        if (bookDTO.getPublisher() == null || bookDTO.getPublisher().trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher must not be empty or null");
        }
        if (bookDTO.getPublisher().length() > 100) {
            throw new IllegalArgumentException("Publisher must not exceed 100 characters");
        }

        // Validate Publish Year
        if (bookDTO.getPublishYear() == null) {
            throw new IllegalArgumentException("Publish Year must not be null");
        }
        int currentYear = Year.now().getValue();
        if (bookDTO.getPublishYear() < 1450 || bookDTO.getPublishYear() > currentYear) {
            throw new IllegalArgumentException("Publish Year must be between 1450 and " + currentYear);
        }

        // Validate Genre
        if (bookDTO.getGenre() == null || bookDTO.getGenre().trim().isEmpty()) {
            throw new IllegalArgumentException("Genre must not be empty or null");
        }

        // Validate Active Flag
        if (!bookDTO.isActiveFlag() && !bookDTO.isActiveFlag()) {
            throw new IllegalArgumentException("Active Flag must be true or false");
        }
    }

}
