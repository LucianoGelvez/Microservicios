package com.dh.movies.service;

import com.dh.movies.dto.MovieRequest;
import com.dh.movies.dto.MovieResponse;
import com.dh.movies.entity.Movie;
import com.dh.movies.message.MessageSender;
import com.dh.movies.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService {
    private final IMovieRepository movieRepository;
    private final MessageSender messageSender;

    @Override
    public List<MovieResponse> findAll(String genre) {
        return movieRepository.findAll().stream()
                .map(MovieResponse::new).filter(movie -> genre == null || movie.getGenre().equalsIgnoreCase(genre)).toList();
    }

    @Override
    public MovieResponse findById(Long id) {
        return movieRepository.findById(id)
                .map(MovieResponse::new).orElseThrow(()->
                        new RuntimeException("No se encontro la pelicula con id: " + id));
    }
    @Override
    public MovieResponse save(MovieRequest movie) {
        Movie movieSave = new Movie();
        movieSave.setName(movie.getName());
        movieSave.setGenre(movie.getGenre());
        movieSave.setUrlStream(movie.getUrlStream());

        Movie movieSaved = movieRepository.save(movieSave);
        messageSender.send(movieSaved);
        return new MovieResponse(movieSaved);
    }

    @Override
    public MovieResponse update(Long id, MovieRequest movie) {
        Movie movieUpdate = movieRepository.findById(id).orElseThrow(()->
                new RuntimeException("No se encontro la pelicula con id: " + id));
        if (movie.getName() != null)
            movieUpdate.setName(movie.getName());
        if (movie.getGenre() != null)
            movieUpdate.setGenre(movie.getGenre());
        if (movie.getUrlStream() != null)
            movieUpdate.setUrlStream(movie.getUrlStream());

        Movie movieUpdated = movieRepository.save(movieUpdate);
        messageSender.send(movieUpdated);
        return new MovieResponse(movieUpdated);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
