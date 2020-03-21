package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.CookieValue;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.CookieValuesRepository;
import ru.itis.moviehub.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public String signIn(String login, String password, Boolean isNeedCookie) {
        Optional<User> userOptional = usersRepository.findByLogin(login);

        String value = null;
        if (isNeedCookie) {
            if (userOptional.isPresent() && userOptional.get().getHashPassword().equals(password)) {
                value = UUID.randomUUID().toString();
                CookieValue cookieValue = CookieValue.builder()
                        .value(value)
                        .user(userOptional.get())
                        .build();
                cookieValuesRepository.save(cookieValue);
            }
        }
        return value;
    }
}
