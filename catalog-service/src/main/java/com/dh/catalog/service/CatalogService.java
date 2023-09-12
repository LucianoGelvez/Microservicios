package com.dh.catalog.service;

import com.dh.catalog.exceptions.NotFoundException;
import com.dh.catalog.models.Catalog;
import com.dh.catalog.models.Movie;
import com.dh.catalog.models.Serie;
import com.dh.catalog.repository.CatalogRepository;
import com.dh.catalog.repository.MoviesRepository;
import com.dh.catalog.repository.SeriesRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService implements ICatalogService {

    public final CatalogRepository catalogRepository;

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findById(String id) {
        return catalogRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Catalog with id %s not found", id)));
    }

    @Override
    public List<Catalog> findAllByGenre(String genre) {
        return catalogRepository.findAllByGenreIgnoreCase(genre);
    }


    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog updateById(String id, Catalog catalog) {
        Catalog catalogToUpdate = findById(id);
        catalogToUpdate.setGenre(catalog.getGenre());
        catalogToUpdate.setMovies(catalog.getMovies());
        catalogToUpdate.setSeries(catalog.getSeries());
        return catalogRepository.save(catalogToUpdate);
    }

    @Override
    public void deleteById(String id) {
        Catalog catalogToDelete = findById(id);
        catalogRepository.delete(catalogToDelete);
    }

    @Override
    public Movie saveMovi(Movie movie) {
        return null;
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return null;
    }

//    private Movie createMovieFallback(CallNotPermittedException exception){
//        return exception
//    }
}
