package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.Actor;

public interface ActorsRepository extends JpaRepository<Actor, Long> {
}
