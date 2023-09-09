package com.dh.catalog.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "catalogs")
@AllArgsConstructor
public class Catalog {
    @Id
    public String id;
    public String genre;
    public List<Movie> movies;
    public List<Serie> series;
}
