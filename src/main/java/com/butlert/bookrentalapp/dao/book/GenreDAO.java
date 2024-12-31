package com.butlert.bookrentalapp.dao.book;

import com.butlert.bookrentalapp.dto.book.GenreDTO;

import java.util.List;

public interface GenreDAO {
    GenreDTO saveGenre(GenreDTO genreDTO);

    GenreDTO findGenreById(Long id);

    List<GenreDTO> findAllGenres();
}