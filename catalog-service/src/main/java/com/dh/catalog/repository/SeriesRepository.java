package com.dh.catalog.repository;

import com.dh.catalog.models.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service", path = "/series")
public interface SeriesRepository {

    @GetMapping("/{id}")
    Serie findById(@PathVariable Long id);

    @GetMapping("/genres/{genre}")
    List<Serie> findAllByGenre(@PathVariable String genre);
}
