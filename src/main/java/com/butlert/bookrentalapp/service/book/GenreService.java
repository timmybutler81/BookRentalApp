package com.butlert.bookrentalapp.service.book;

import com.butlert.bookrentalapp.dao.book.GenreDAO;
import com.butlert.bookrentalapp.dto.book.GenreDTO;
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

    public GenreDTO addOrUpdateGenre(GenreDTO genreDTO) {
        validatorImp.validate(genreDTO);
        return genreDAO.saveGenre(genreDTO);
    }

    public GenreDTO getGenreById(Long id) {
        return genreDAO.findGenreById(id);
    }

    public List<GenreDTO> getAllGenres() {
        return genreDAO.findAllGenres();
    }
}