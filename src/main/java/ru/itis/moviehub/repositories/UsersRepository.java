package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);
    Optional<User> findByConfirmCode(String confirmCode);
    List<User> findAllByNameContainsIgnoreCase(String name);
}
