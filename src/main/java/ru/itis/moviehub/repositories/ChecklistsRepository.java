package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.User;

import java.util.List;

public interface ChecklistsRepository extends JpaRepository<Checklist, Integer> {

    @Query("select c from Checklist c where c.user = :user")
    List<Checklist> findByUserId(User user);
}
