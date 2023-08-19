package com.dh.catalog.service;

import com.dh.catalog.models.Catalog;
import com.dh.catalog.models.Movie;
import com.dh.catalog.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogService implements ICatalogService {

    public final MoviesRepository moviesRepository;

    @Override
    public List<Catalog> findAll() {
        return moviesRepository.findAllMovies(null).stream()
                .collect(Collectors.groupingBy(Movie::getGenre))
                .entrySet().stream()
                .map(entry -> new Catalog(entry.getKey(), entry.getValue()))
                .toList();
    }

    @Override
    public Catalog findByGenre(String genre) {
        return new Catalog(genre, moviesRepository.findAllMovies(genre));
    }
}
