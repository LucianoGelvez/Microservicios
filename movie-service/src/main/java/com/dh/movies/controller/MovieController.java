package com.dh.movies.controller;

import com.dh.movies.dto.MovieRequest;
import com.dh.movies.dto.MovieResponse;
import com.dh.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService peliculasService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(@RequestParam(required = false) String genre) {
        return ResponseEntity.ok(peliculasService.findAll(genre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(peliculasService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculasService.save(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> updateById(@PathVariable Long id, @RequestBody MovieRequest movie) {
        return ResponseEntity.status(HttpStatus.OK).body(peliculasService.update(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        peliculasService.deleteById(id);
        return ResponseEntity.ok("Se elimino la pelicula de id: " + id);
    }
}
