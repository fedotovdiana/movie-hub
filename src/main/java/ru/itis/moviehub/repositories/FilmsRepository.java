package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.moviehub.models.Film;

import java.util.Date;
import java.util.List;

public interface FilmsRepository extends JpaRepository<Film, Integer> {

    @Query("select f from Film f where f.date > :currentDate")
    List<Film> findAfisha(Date currentDate);

    List<Film> findAllByNameContainsIgnoreCase(String name);
}
