package ru.itis.moviehub.services;

import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.models.User;

public interface LikesService {
    Long getLikes(Long filmId);

    Long getDislikes(Long filmId);

    void addLike(User user, Film film);

    void addDislike(User user, Film film);
}
