package com.dh.catalog.service;

import com.dh.catalog.models.Catalog;
import com.dh.catalog.models.Movie;
import com.dh.catalog.models.Serie;

import java.util.List;

public interface ICatalogService {
    List<Catalog> findAll();
    Catalog findById(String id);
    List<Catalog> findAllByGenre(String genre);
    Catalog save(Catalog catalog);
    Catalog updateById(String id, Catalog catalog);
    void deleteById(String id);
    Movie saveMovi(Movie movie);
    Serie saveSerie(Serie serie);
}
