package com.dh.serie.config;

import com.dh.serie.entity.Serie;
import com.dh.serie.repository.SerieRepository;
import com.dh.serie.service.ISerieService;
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

    private final SerieRepository serieRepository;
    private final ISerieService serieService;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("import.json");
        Serie[] series = objectMapper.readValue(resource.getInputStream(), Serie[].class);

        for (Serie serie : series) {
            serieService.save(serie);
        }

    }

    @PreDestroy
    public void shutdown() {
        serieRepository.deleteAll();
    }
}
