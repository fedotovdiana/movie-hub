package ru.itis.moviehub.services;

import ru.itis.moviehub.dto.FilmSearchResult;
import ru.itis.moviehub.models.Film;

import java.util.List;

public interface FilmsService {
    List<Film> getFilms();

    Film getConcreteFilm(Long id);

    List<Film> getAfisha();

    FilmSearchResult search(String query, Integer page, Integer size);

    List<Film> getTopFilms();
}
