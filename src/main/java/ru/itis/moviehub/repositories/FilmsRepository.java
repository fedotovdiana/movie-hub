package ru.itis.moviehub.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.moviehub.models.Film;

import java.util.Date;
import java.util.List;

public interface FilmsRepository extends JpaRepository<Film, Long> {

    @Query("select f from Film f where f.date > :currentDate")
    List<Film> findAfisha(Date currentDate);

    List<Film> findAllByNameContainsIgnoreCase(String name);

    @Query(value = "SELECT * FROM films ORDER BY (SELECT COUNT(*) FROM likes WHERE film_id = films.id) DESC LIMIT 4",
            nativeQuery = true)
    List<Film> findTopFilms();

    @Query("from Film film where " +
            "upper(film.name) like concat('%', upper(:query), '%') or " +
            "upper(film.country) like concat('%', upper(:query), '%')")
    Page<Film> search(@Param("query") String query, Pageable pageable);
}
