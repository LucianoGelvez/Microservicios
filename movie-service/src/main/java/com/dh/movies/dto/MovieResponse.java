package com.dh.movies.dto;

import com.dh.movies.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieResponse {
    private String name;
    private String genre;
    private String urlStream;

    public MovieResponse(Movie movie) {
        this.name = movie.getName();
        this.genre = movie.getGenre();
        this.urlStream = movie.getUrlStream();
    }
}
