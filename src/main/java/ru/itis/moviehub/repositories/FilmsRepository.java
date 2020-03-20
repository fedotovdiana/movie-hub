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

    //SELECT * FROM films ORDER BY (SELECT COUNT(*) FROM likes WHERE film_id = films.id) DESC LIMIT 4
    //@Query("select f from Film f order by (select t from Like where f.id = like.film_id) desc")
    @Query(value = "SELECT * FROM films ORDER BY (SELECT COUNT(*) FROM likes WHERE film_id = films.id) DESC LIMIT 4",
            nativeQuery = true)
    List<Film> findTopFilms();
}
