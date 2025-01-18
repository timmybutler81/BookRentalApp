package com.butlert.bookrentalapp.dao.book;

import com.butlert.bookrentalapp.dto.book.BookDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDAO {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BookDTO> searchBooksByKeyword(@Param("keyword") String keyword);
}
