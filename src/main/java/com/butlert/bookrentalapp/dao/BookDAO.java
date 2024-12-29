package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.dto.BookDTO;

import java.util.List;

public interface BookDAO {

    List<BookDTO> findAllBooks();

    BookDTO findBookById(Long id);

    BookDTO saveBook(Book book);

    List<BookDTO> findBooksByTitleKeyword(String keyword);

    List<BookDTO> findBookByGenre(String genre);
}
