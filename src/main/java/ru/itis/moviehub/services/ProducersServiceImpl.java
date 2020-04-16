package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Producer;
import ru.itis.moviehub.models.ProducerFilm;
import ru.itis.moviehub.repositories.ProducerFilmsRepository;
import ru.itis.moviehub.repositories.ProducersRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProducersServiceImpl implements ProducersService {

    @Autowired
    ProducersRepository producersRepository;

    @Autowired
    ProducerFilmsRepository producerFilmsRepository;

    @Override
    public List<Producer> getProducers() {
        return producersRepository.findAll();
    }

    @Override
    public Producer getConcreteProducer(Long producerId) {
        return producersRepository.getOne(producerId);
    }

    @Override
    public List<Producer> getProducersByFilm(Long filmId) {
        List<ProducerFilm> producerFilms = producerFilmsRepository.getProducerFilmsByFilmId(filmId);
        List<Producer> producers = new LinkedList<>();
        for (ProducerFilm pf : producerFilms) {
            Producer producer = producersRepository.getOne(pf.getId());
            producers.add(producer);
        }
        return producers;
    }
}
