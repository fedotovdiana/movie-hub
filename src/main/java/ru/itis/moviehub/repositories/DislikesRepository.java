package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.moviehub.models.Dislike;

public interface DislikesRepository extends JpaRepository<Dislike, Long> {

    @Query(value = "SELECT COUNT (*) FROM dislikes WHERE :filmId", nativeQuery = true)
    Integer getDislikes(Long filmId);

    Long countByFilmId(Long filmId);
}
