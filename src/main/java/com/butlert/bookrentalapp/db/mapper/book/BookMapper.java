package com.butlert.bookrentalapp.db.mapper.book;

import com.butlert.bookrentalapp.db.entity.book.Book;
import com.butlert.bookrentalapp.dto.book.BookDTO;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                book.getGenre(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublisher(),
                book.getPublishYear(),
                book.isActiveFlag()
        );
    }

    public static Book toEntity(BookDTO bookDTO) {
        return new Book(
                bookDTO.getId(),
                bookDTO.getGenre(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getIsbn(),
                bookDTO.getPublisher(),
                bookDTO.getPublishYear(),
                bookDTO.isActiveFlag()
        );
    }
}