package com.butlert.bookrentalapp.dao.Impl;

import com.butlert.bookrentalapp.dao.book.GenreDAO;
import com.butlert.bookrentalapp.db.entity.book.Genre;
import com.butlert.bookrentalapp.db.mapper.book.GenreMapper;
import com.butlert.bookrentalapp.db.repository.book.GenreRepository;
import com.butlert.bookrentalapp.dto.book.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GenreDAOImpl implements GenreDAO {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        Genre genre = GenreMapper.toEntity(genreDTO);
        Genre savedGenre = genreRepository.save(genre);
        return GenreMapper.toDTO(savedGenre);
    }

    @Override
    public GenreDTO findGenreById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return GenreMapper.toDTO(genre);
    }

    @Override
    public List<GenreDTO> findAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(GenreMapper::toDTO)
                .collect(Collectors.toList());
    }


}
