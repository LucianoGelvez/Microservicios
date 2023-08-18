package com.dh.catalog.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Catalog {
    public String genre;
    public List<Movie> movies;
}
