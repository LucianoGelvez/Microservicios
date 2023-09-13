package com.dh.catalog.message;

import com.dh.catalog.models.Catalog;
import com.dh.catalog.models.Movie;
import com.dh.catalog.models.Serie;
import com.dh.catalog.repository.MoviesRepository;
import com.dh.catalog.repository.SeriesRepository;
import com.dh.catalog.service.ICatalogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageListener {

    private final ICatalogService catalogService;
    private final MoviesRepository moviesRepository;
    private final SeriesRepository seriesRepository;
    private final ObjectMapper objectMapper;


    @RabbitListener(queues = "${queue.serie.name}")
    public void receiveMessageSerie(@Payload GenericMessage<String> serie) {
        processSerieMessage(serie.getPayload());
    }

    @RabbitListener(queues = "${queue.movie.name}")
    public void receiveMessageMovie(@Payload GenericMessage<String> movie) {
        processMovieMessage(movie.getPayload());
    }

    @CircuitBreaker(name = "catalog-post", fallbackMethod = "fallbackProcessMessage")
    @Retry(name = "catalog-post")
    private void processSerieMessage(String seriePayload) {
        try {
            log.info("[RECEIVE MESSAGE] SERIE -> {}", seriePayload);

            Serie serieObject = objectMapper.readValue(seriePayload, Serie.class);
            List<Movie> movies = moviesRepository.findAllByGenre(serieObject.getGenre());
            List<Serie> series = seriesRepository.findAllByGenre(serieObject.getGenre());
            updateCatalogWithSerie(serieObject, movies, series);
        } catch (Exception e) {
            log.error("[ERROR] {}", e.getMessage());
        }
    }
    @CircuitBreaker(name = "catalog-post", fallbackMethod = "fallbackProcessMessage")
    @Retry(name = "catalog-post")
    private void processMovieMessage(String moviePayload) {
        try {
            log.info("[RECEIVE MESSAGE] MOVIE -> {}", moviePayload);

            Movie movieObject = objectMapper.readValue(moviePayload, Movie.class);
            List<Movie> movies = moviesRepository.findAllByGenre(movieObject.getGenre());
            List<Serie> series = seriesRepository.findAllByGenre(movieObject.getGenre());
            updateCatalogWithMovie(movieObject, movies, series);
        } catch (Exception e) {
            log.error("[ERROR] {}", e.getMessage());
        }
    }
    private void fallbackProcessMessage(String payload, Exception e) {
        log.error("[ERROR] Fallback method called for payload: {}", payload);
    }

    private void updateCatalogWithSerie(Serie serie, List<Movie> movies, List<Serie> series) {
        List<Catalog> catalogs = catalogService.findAllByGenre(serie.getGenre());

        if (catalogs.isEmpty()) {
            Catalog catalog = new Catalog(null, serie.getGenre(), movies, series);
            catalogService.save(catalog);
        } else {
            catalogs.forEach(catalog -> {
                List<Serie> seriesInCatalog = catalog.getSeries();
                if (seriesInCatalog.stream().anyMatch(serie1 -> serie1.getId().equals(serie.getId()))) {
                    seriesInCatalog.stream().filter(serie1 -> serie1.getId().equals(serie.getId())).forEach(serie1 -> {
                        serie1.setName(serie.getName());
                        serie1.setGenre(serie.getGenre());
                        serie1.setSeasons(serie.getSeasons());
                    });
                } else {
                    seriesInCatalog.add(serie);
                }
                catalog.setSeries(seriesInCatalog);
                catalogService.save(catalog);
            });
        }
    }

    private void updateCatalogWithMovie(Movie movie, List<Movie> movies, List<Serie> series) {
        List<Catalog> catalogs = catalogService.findAllByGenre(movie.getGenre());

        if (catalogs.isEmpty()) {
            Catalog catalog = new Catalog(null, movie.getGenre(), movies, series);
            catalogService.save(catalog);
        } else {
            catalogs.forEach(catalog -> {
                List<Movie> moviesInCatalog = catalog.getMovies();
                if (moviesInCatalog.stream().anyMatch(movie1 -> movie1.getName().equals(movie.getName()))) {
                    moviesInCatalog.stream().filter(movie1 -> movie1.getName().equals(movie.getName())).forEach(movie1 -> {
                        movie1.setName(movie.getName());
                        movie1.setGenre(movie.getGenre());
                        movie1.setUrlStream(movie.getUrlStream());
                    });
                } else {
                    moviesInCatalog.add(movie);
                }
                catalog.setMovies(moviesInCatalog);
                catalogService.save(catalog);
            });
        }
    }
}
