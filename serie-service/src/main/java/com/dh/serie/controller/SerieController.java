package com.dh.serie.controller;

import com.dh.serie.entity.Serie;
import com.dh.serie.service.ISerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/series")
public class SerieController {

    private final ISerieService serieService;

    @RequestMapping
    public ResponseEntity<List<Serie>> findAll(){
        return ResponseEntity.ok(serieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> findById(@PathVariable String id){
        return ResponseEntity.ok(serieService.findById(id));
    }

    @GetMapping("/genres/{genre}")
    public ResponseEntity<List<Serie>> findAllByGenre(@PathVariable String genre){
        return ResponseEntity.ok(serieService.findAllByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.save(serie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateById(@PathVariable String id, @RequestBody Serie serie) {
        return ResponseEntity.ok(serieService.updateById(id, serie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        serieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
