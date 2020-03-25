package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.dto.SignUpDto;
import ru.itis.moviehub.dto.UserDto;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

import static ru.itis.moviehub.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByNameContainsIgnoreCase(name));
    }

    @Override
    public void updateUser(SignUpDto form, Long id) {
        Optional<User> userOptional = usersRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(form.getName());
            user.setLogin(form.getLogin());
            user.setHashPassword(passwordEncoder.encode(form.getPassword()));
            if (form.getPhoto() != null)
                user.setPhoto(form.getPhoto());
            usersRepository.save(user);
        }
    }
}
