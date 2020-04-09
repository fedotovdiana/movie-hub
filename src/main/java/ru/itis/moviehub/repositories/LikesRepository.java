package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.moviehub.models.Like;

public interface LikesRepository extends JpaRepository<Like, Long> {

    @Query(value = "SELECT COUNT (*) FROM likes WHERE film_id:filmId", nativeQuery = true)
    Integer getLikes(Integer filmId);

    Long countByFilmId(Integer filmId);
}
