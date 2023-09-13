package com.dh.catalog.repository;

import com.dh.catalog.models.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String> {
    List<Catalog> findAllByGenreIgnoreCase(String genre);
}
