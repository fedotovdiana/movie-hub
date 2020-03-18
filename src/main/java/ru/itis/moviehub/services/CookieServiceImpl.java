package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.repositories.CookieValuesRepository;

@Service
public class CookieServiceImpl implements CookieService {

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Override
    public boolean isExist(String cookie) {
        return cookieValuesRepository.findByValue(cookie) != null;
    }
}
