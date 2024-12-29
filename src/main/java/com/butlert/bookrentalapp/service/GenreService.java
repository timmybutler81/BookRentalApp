package com.butlert.bookrentalapp.service;

import com.butlert.bookrentalapp.dao.GenreDAO;
import com.butlert.bookrentalapp.db.entity.Genre;
import com.butlert.bookrentalapp.db.mapper.GenreMapper;
import com.butlert.bookrentalapp.dto.GenreDTO;
import com.butlert.bookrentalapp.validator.ValidatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private ValidatorImp validatorImp;

    @Autowired
    private GenreDAO genreDAO;

    public List<GenreDTO> getAllGenres() {
        return genreDAO.findAllGenres();
    }

    public GenreDTO getGenreById(Long id) {
        return genreDAO.findGenreById(id);
    }

    public GenreDTO saveGenre(GenreDTO genreDTO) {
        validatorImp.validate(genreDTO);
        Genre genre = GenreMapper.toEntity(genreDTO);
        return genreDAO.saveGenre(genre);
    }
}