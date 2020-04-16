package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.ScriptwriterFilm;

import java.util.List;

public interface ScriptwriterFilmsRepository extends JpaRepository<ScriptwriterFilm, Long> {
    List<ScriptwriterFilm> getScriptwriterFilmByFilmId(Long filmId);
}
