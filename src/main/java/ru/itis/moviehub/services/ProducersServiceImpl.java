package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Producer;
import ru.itis.moviehub.repositories.ProducersRepository;

import java.util.List;

@Service
public class ProducersServiceImpl implements ProducersService {

    @Autowired
    private ProducersRepository producersRepository;

    @Override
    public List<Producer> getProducers() {
        return producersRepository.findAll();
    }

    @Override
    public Producer getConcreteProducer(Integer producerId) {
        return producersRepository.getOne(producerId);
    }
}
