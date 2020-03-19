package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.Producer;

public interface ProducersRepository extends JpaRepository<Producer, Integer> {
}
