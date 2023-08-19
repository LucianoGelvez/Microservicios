package com.dh.movies.service;

import com.dh.movies.dto.MovieRequest;
import com.dh.movies.dto.MovieResponse;

import java.util.List;

public interface IMovieService {
    List<MovieResponse> findAll(String genre);
    MovieResponse findById(Long id);
    MovieResponse save(MovieRequest movie);
    MovieResponse update(Long id, MovieRequest movie);
    void deleteById(Long id);

}
