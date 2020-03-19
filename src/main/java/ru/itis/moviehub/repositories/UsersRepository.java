package ru.itis.moviehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.moviehub.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    Optional<User> findByConfirmCode(String confirmCode);
}
