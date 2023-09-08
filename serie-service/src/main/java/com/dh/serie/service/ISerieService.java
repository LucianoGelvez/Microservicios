package com.dh.serie.service;

import com.dh.serie.entity.Serie;

import java.util.List;

public interface ISerieService {
    List<Serie> findAll();
    List<Serie> findAllByGenre(String genre);
    Serie findById(String id);
    Serie save(Serie serie);
    Serie updateById(String id, Serie serie);
    void deleteById(String id);
}
