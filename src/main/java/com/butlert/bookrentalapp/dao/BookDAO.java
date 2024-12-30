package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Book;
import com.butlert.bookrentalapp.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

    List<BookDTO> findAllBooks();

    Optional<BookDTO> findBookById(Long id);

    BookDTO saveBook(Book book);

    List<BookDTO> findBooksByTitleKeyword(String keyword);

    List<BookDTO> findBookByGenre(String genre);
}
