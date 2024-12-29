package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.dto.BookDTO;

public class BookMapper {

    public static BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getGenre(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getPublishYear(), book.isActiveFlag());
    }

    public static Book toEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setGenre(bookDTO.getGenre());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublishYear(bookDTO.getPublishYear());
        book.setActiveFlag(bookDTO.isActiveFlag());
        return book;
    }
}
