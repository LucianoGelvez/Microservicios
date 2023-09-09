package com.dh.serie.repository;

import com.dh.serie.entity.Serie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie, String> {
    List<Serie> findAllByGenreIgnoreCase(String genre);
}
