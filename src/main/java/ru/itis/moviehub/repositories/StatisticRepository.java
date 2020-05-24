package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
