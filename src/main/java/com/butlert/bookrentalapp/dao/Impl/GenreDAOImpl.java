package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.GenreDAO;
import com.butlert.bookrentalapp.db.entity.Genre;
import com.butlert.bookrentalapp.db.mapper.GenreMapper;
import com.butlert.bookrentalapp.db.repository.GenreRepository;
import com.butlert.bookrentalapp.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreDTO> findAllGenres() {
        return genreRepository.findAll().stream().map(GenreMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public GenreDTO findGenreById(Long id) {
        return genreRepository.findById(id).map(GenreMapper::toDTO).orElseThrow(() -> new RuntimeException("Genre Not Found"));
    }

    @Override
    public GenreDTO saveGenre(Genre genre) {
        Genre savedGenre = genreRepository.save(genre);
        return GenreMapper.toDTO(savedGenre);
    }
}
