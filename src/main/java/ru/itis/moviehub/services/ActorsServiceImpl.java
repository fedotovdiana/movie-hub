package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Actor;
import ru.itis.moviehub.models.ActorFilm;
import ru.itis.moviehub.repositories.ActorFilmsRepository;
import ru.itis.moviehub.repositories.ActorsRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class ActorsServiceImpl implements ActorsService {

    @Autowired
    ActorsRepository actorsRepository;

    @Autowired
    ActorFilmsRepository actorFilmsRepository;

    @Override
    public List<Actor> getActors() {
        return actorsRepository.findAll();
    }

    @Override
    public Actor getConcreteActor(Long actorId) {
        return actorsRepository.getOne(actorId);
    }

    @Override
    public List<Actor> getActorsByFilm(Long filmId) {
        List<ActorFilm> actorFilms = actorFilmsRepository.getActorFilmsByFilmId(filmId);
        List<Actor> actors = new LinkedList<>();
        for (ActorFilm actorFilm : actorFilms) {
            Actor actor = actorsRepository.getOne(actorFilm.getId());
            actors.add(actor);
        }
        return actors;
    }
}
