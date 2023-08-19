package com.dh.catalog.service;

import com.dh.catalog.models.Catalog;

import java.util.List;

public interface ICatalogService {
    List<Catalog> findAll();
    Catalog findByGenre(String genre);
}
