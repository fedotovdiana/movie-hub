package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.moviehub.models.Film;

import java.util.List;

public interface FilmsRepository extends JpaRepository<Film, Integer> {

    @Query("SELECT f FROM Film f WHERE f.date = :time")
    List<Film> getAfisha();

    List<Film> findAllByNameContainsIgnoreCase(String name);
}
