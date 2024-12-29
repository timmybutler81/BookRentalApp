package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.BookStatus;
import com.butlert.bookrentalapp.dto.BookStatusDTO;

import java.util.List;

public interface BookStatusDAO {
    List<BookStatusDTO> findAllBookStatuses();

    BookStatusDTO findBookStatusById(Long id);

    BookStatusDTO saveBookStatus(BookStatus bookStatus);
}
