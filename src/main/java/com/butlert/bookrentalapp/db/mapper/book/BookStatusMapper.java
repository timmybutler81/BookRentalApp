package com.butlert.bookrentalapp.db.mapper.book;

import com.butlert.bookrentalapp.db.entity.book.BookStatus;
import com.butlert.bookrentalapp.dto.book.BookStatusDTO;

public class BookStatusMapper {

    public static BookStatusDTO toDTO(BookStatus bookStatus) {
        return new BookStatusDTO(bookStatus.getId(), bookStatus.getBookStatusName(), bookStatus.isActiveFlag());
    }

    public static BookStatus toEntity(BookStatusDTO bookStatusDTO) {
        BookStatus bookStatus = new BookStatus();
        bookStatus.setId(bookStatusDTO.getId());
        bookStatus.setBookStatusName(bookStatusDTO.getBookStatusName());
        bookStatus.setActiveFlag(bookStatusDTO.isActiveFlag());
        return bookStatus;
    }
}
