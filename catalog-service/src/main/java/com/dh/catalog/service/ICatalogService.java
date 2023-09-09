package com.dh.catalog.service;

import com.dh.catalog.models.Catalog;

import java.util.List;

public interface ICatalogService {
    List<Catalog> findAll();
    Catalog findById(String id);
    List<Catalog> findAllByGenre(String genre);
    Catalog save(Catalog catalog);
    Catalog updateById(String id, Catalog catalog);
    void deleteById(String id);
}
