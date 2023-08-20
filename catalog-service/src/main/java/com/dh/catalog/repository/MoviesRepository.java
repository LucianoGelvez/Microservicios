package com.dh.catalog.repository;

import com.dh.catalog.config.CustomLoadBalancerConfiguration;
import com.dh.catalog.models.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "movie-service", path = "/movies", configuration = CustomLoadBalancerConfiguration.class)
public interface MoviesRepository {

    @GetMapping
    List<Movie> findAllMovies(@RequestParam(required = false) String genre);

}
