package com.dh.serie.service;

import com.dh.serie.entity.Serie;
import com.dh.serie.exceptions.NotFoundException;
import com.dh.serie.message.MessageSender;
import com.dh.serie.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService implements ISerieService {

    private final SerieRepository serieRepository;
    private final MessageSender messageSender;

    @Override
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    @Override
    public List<Serie> findAllByGenre(String genre) {
        return serieRepository.findAllByGenreIgnoreCase(genre);
    }

    @Override
    public Serie findById(String id) {
        return serieRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Serie with id %s not found", id)));
    }

    @Override
    public Serie save(Serie serie) {
        Serie serieSaved = serieRepository.save(serie);
        messageSender.send(serieSaved);
        return serieSaved;
    }

    @Override
    public Serie updateById(String id, Serie serie) {
        Serie serieToUpdate = findById(id);
        serieToUpdate.setName(serie.getName());
        serieToUpdate.setGenre(serie.getGenre());
        serieToUpdate.setSeasons(serie.getSeasons());
        return serieRepository.save(serieToUpdate);
    }

    @Override
    public void deleteById(String id) {
        Serie serieToDelete = findById(id);
        serieRepository.delete(serieToDelete);
    }
}
