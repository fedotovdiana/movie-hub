package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.Checklist;

import java.util.List;
import java.util.Optional;

public interface ChecklistsRepository extends JpaRepository<Checklist, Long> {

    List<Checklist> findByUserId(Long userId);

    Optional<Checklist> findByName(String name);
}
