package com.butlert.bookrentalapp.dao.book;

import com.butlert.bookrentalapp.dto.book.BookDTO;

import java.util.List;

public interface BookDAO {
    BookDTO saveBook(BookDTO bookDTO);

    BookDTO findBookById(Long id);

    List<BookDTO> findAllBooks();

    List<BookDTO> findBooksByGenre(String genre);

    List<BookDTO> searchBooksByKeyword(String keyword);
}
