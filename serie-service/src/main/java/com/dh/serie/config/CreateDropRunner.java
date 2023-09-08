package com.dh.serie.config;

import com.dh.serie.entity.Serie;
import com.dh.serie.repository.SerieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CreateDropRunner {

    private final SerieRepository serieRepository;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("import.json");
        Serie[] series = objectMapper.readValue(resource.getInputStream(), Serie[].class);
        serieRepository.saveAll(Arrays.stream(series).toList());
    }

    @PreDestroy
    public void shutdown() {
        serieRepository.deleteAll();
    }
}
