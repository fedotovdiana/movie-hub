package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.CookieValue;

public interface CookieValuesRepository extends JpaRepository<CookieValue, Long> {
    CookieValue findByValue(String value);
}