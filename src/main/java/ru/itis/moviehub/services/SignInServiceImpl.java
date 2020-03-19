package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.CookieValue;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.repositories.CookieValuesRepository;
import ru.itis.moviehub.repositories.UsersRepository;

import java.util.UUID;

@Service
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public String signIn(String login, String password, Boolean isNeedCookie) {
        User user = usersRepository.findByLogin(login);

        String value = null;
        if (isNeedCookie) {
            if (user != null && user.getPassword().equals(password)) {
                value = UUID.randomUUID().toString();
                CookieValue cookieValue = CookieValue.builder()
                        .value(value)
                        .user(user)
                        .build();
                cookieValuesRepository.save(cookieValue);
            }
        }
        return value;
    }
}
