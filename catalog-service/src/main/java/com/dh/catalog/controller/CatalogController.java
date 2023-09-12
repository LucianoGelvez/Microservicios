package com.dh.catalog.controller;

import com.dh.catalog.models.Catalog;
import com.dh.catalog.models.Movie;
import com.dh.catalog.repository.MoviesRepository;
import com.dh.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogoService;

    @GetMapping
    public ResponseEntity<List<Catalog>> findAll() {
        return ResponseEntity.ok(catalogoService.findAll());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Catalog>> findByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(catalogoService.findAllByGenre(genre));
    }

}

