package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Actor;

import java.util.List;

public interface ActorsService {
    List<Actor> getActors();
    Actor getConcreteActor(Integer id);
}
