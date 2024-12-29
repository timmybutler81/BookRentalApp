package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Book> searchBooksByTitleKeyword(@Param("keyword") String keyword);

    @Query(value = "SELECT b.book_id, b.genre_id, b.title, b.author, b.isbn, b.publisher, b.publish_year, b.active_flag\n" +
            "FROM book b\n" +
            "JOIN genre g ON b.genre_id = g.genre_id\n" +
            "WHERE LOWER(g.genre_name) LIKE LOWER(CONCAT('%', :genre, '%'));", nativeQuery = true)
    List<Book> findBookByGenre(@Param("genre") String genre);
}