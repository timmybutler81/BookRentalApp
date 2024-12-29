package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.dto.BookStatusDTO;

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
