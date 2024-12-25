package com.butlert.bookrentalapp.dao;

import com.butlert.bookrentalapp.db.entity.Genre;
import com.butlert.bookrentalapp.dto.GenreDTO;

import java.util.List;

public interface GenreDAO {

    List<GenreDTO> findAllGenres();

    GenreDTO findGenreById(Long id);

    GenreDTO saveGenre(Genre genre);

}