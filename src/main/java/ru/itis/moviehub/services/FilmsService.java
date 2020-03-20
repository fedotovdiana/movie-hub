package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Film;

import java.util.List;

public interface FilmsService {
    List<Film> getFilms();
    Film getConcreteFilm(Integer id);
    List<Film> getAfisha();
    List<Film> search(String name);
}
