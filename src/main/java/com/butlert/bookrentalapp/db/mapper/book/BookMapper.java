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
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setGenre(bookDTO.getGenre());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setActiveFlag(bookDTO.isActiveFlag());
        return book;
    }
}
