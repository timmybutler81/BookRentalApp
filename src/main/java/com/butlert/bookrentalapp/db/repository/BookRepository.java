package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);
}
