package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.ActorFilm;

import java.util.List;

public interface ActorFilmsRepository extends JpaRepository<ActorFilm, Long> {
    List<ActorFilm> getActorFilmsByFilmId(Long filmId);
}
