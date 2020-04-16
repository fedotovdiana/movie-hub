package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Producer;

import java.util.List;

public interface ProducersService {
    List<Producer> getProducers();

    Producer getConcreteProducer(Long producerId);

    List<Producer> getProducersByFilm(Long filmId);
}
