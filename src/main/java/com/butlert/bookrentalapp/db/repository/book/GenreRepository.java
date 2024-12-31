package com.butlert.bookrentalapp.db.repository.book;

import com.butlert.bookrentalapp.db.entity.book.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
