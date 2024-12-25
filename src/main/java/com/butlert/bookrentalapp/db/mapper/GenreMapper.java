package com.butlert.bookrentalapp.db.mapper;

import com.butlert.bookrentalapp.db.entity.Genre;
import com.butlert.bookrentalapp.dto.GenreDTO;

public class GenreMapper {

    public static GenreDTO toDTO(Genre genre) {
        return new GenreDTO(genre.getId(), genre.getGenreName(), genre.isActiveFlag());
    }

    public static Genre toEntity(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setGenreName(genreDTO.getGenreName());
        genre.setActiveFlag(genreDTO.isActiveFlag());
        return genre;
    }
}
