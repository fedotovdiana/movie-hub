package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.ProducerFilm;

import java.util.List;

public interface ProducerFilmsRepository extends JpaRepository<ProducerFilm, Long> {
    List<ProducerFilm> getProducerFilmsByFilmId(Long filmId);
}

