package com.butlert.bookrentalapp.controller.book;

import com.butlert.bookrentalapp.dto.book.GenreDTO;
import com.butlert.bookrentalapp.service.book.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/add")
    public ResponseEntity<GenreDTO> addOrUpdateGenre(@RequestBody GenreDTO genreDTO) {
        return ResponseEntity.ok(genreService.addOrUpdateGenre(genreDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable Long id) {
        return ResponseEntity.ok(genreService.getGenreById(id));
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }
}
