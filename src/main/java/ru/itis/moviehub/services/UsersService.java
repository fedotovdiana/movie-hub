package ru.itis.moviehub.services;

import ru.itis.moviehub.dto.SignUpDto;
import ru.itis.moviehub.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getUsers();

    UserDto getConcreteUser(Long userId);

    List<UserDto> search(String name);

    void updateUser(SignUpDto form, Long id);
}
