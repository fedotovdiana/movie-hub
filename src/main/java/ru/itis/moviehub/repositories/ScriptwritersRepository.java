package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.Scriptwriter;

public interface ScriptwritersRepository extends JpaRepository<Scriptwriter, Integer> {
}
