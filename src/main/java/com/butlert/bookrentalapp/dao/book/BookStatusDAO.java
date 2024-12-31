package com.butlert.bookrentalapp.dao.book;

import com.butlert.bookrentalapp.db.entity.book.BookStatus;
import com.butlert.bookrentalapp.dto.book.BookStatusDTO;

import java.util.List;

public interface BookStatusDAO {
    BookStatusDTO saveBookStatus(BookStatusDTO bookStatusDTO);

    BookStatusDTO findBookStatusById(Long id);

    List<BookStatusDTO> findAllBookStatuses();
}
