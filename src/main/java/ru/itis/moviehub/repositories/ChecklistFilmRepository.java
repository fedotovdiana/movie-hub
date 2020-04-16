package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.ChecklistFilm;

import java.util.List;

public interface ChecklistFilmRepository extends JpaRepository<ChecklistFilm, Long> {
    List<ChecklistFilm> getAllById(Long id);
}
