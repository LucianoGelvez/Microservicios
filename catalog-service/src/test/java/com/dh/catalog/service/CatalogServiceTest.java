package com.dh.catalog.service;

import com.dh.catalog.models.Catalog;
import com.dh.catalog.models.Movie;
import com.dh.catalog.repository.MoviesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CatalogServiceTest {

    @Mock
    MoviesRepository moviesRepository;

    @InjectMocks
    CatalogService catalogoService;

    @Test
    @DisplayName("Obtener todas las peliculas agrupadas por genero")
    void getAllMoviesByGenre() throws JsonProcessingException {

        List<Movie> movies = List.of(
                new Movie("Shrek", "Animacion", "https://chiqui.co/shrek"),
                new Movie("Shrek 2", "Animacion", "https://chiqui.co/shrek2"),
                new Movie("Superman", "Accion", "https://chiqui.co/superman"),
                new Movie("Todo Poderoso", "Comedia", "https://chiqui.co/todopoderoso")
        );

        when(moviesRepository.findAllByGenre(any())).thenReturn(movies);

        List<Catalog> peliculasAnimacion = catalogoService.findAll();

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("JSON: " + mapper.writeValueAsString(peliculasAnimacion));

        assertFalse(peliculasAnimacion.isEmpty());
        assertEquals(3, peliculasAnimacion.size());

    }

}
