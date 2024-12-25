package com.butlert.bookrentalapp.db.repository;

import com.butlert.bookrentalapp.db.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
