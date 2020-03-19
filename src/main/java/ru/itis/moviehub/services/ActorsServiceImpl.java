package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Actor;
import ru.itis.moviehub.repositories.ActorsRepository;

import java.util.List;

@Service
public class ActorsServiceImpl implements ActorsService {

    @Autowired
    ActorsRepository actorsRepository;

    @Override
    public List<Actor> getActors() {
        return actorsRepository.findAll();
    }
}
