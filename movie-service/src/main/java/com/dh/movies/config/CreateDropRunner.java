package com.dh.movies.config;

import com.dh.movies.dto.MovieRequest;
import com.dh.movies.repository.IMovieRepository;
import com.dh.movies.service.IMovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CreateDropRunner {

    private final IMovieRepository movieRepository;
    private final IMovieService movieService;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("import.json");
        MovieRequest[] movies = objectMapper.readValue(resource.getInputStream(), MovieRequest[].class);

        for (MovieRequest movie : movies) {
            movieService.save(movie);
        }
    }

    @PreDestroy
    public void shutdown() {
        movieRepository.deleteAll();
    }
}
