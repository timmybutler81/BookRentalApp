package com.butlert.bookrentalapp.controller;

import com.butlert.bookrentalapp.dto.GenreDTO;
import com.butlert.bookrentalapp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<GenreDTO> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public GenreDTO getGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

    @PostMapping("/add")
    public GenreDTO saveGenre(@RequestBody GenreDTO genreDTO) {
        return genreService.saveGenre(genreDTO);
    }
}
