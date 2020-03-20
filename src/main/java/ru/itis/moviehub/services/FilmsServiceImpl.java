package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.repositories.FilmsRepository;

import java.util.Date;
import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    FilmsRepository filmsRepository;

    @Override
    public List<Film> getFilms() {
        return filmsRepository.findAll();
    }

    @Override
    public Film getConcreteFilm(Integer id) {
        return filmsRepository.getOne(id);
    }

    @Override
    public List<Film> getAfisha() {
        return filmsRepository.findAfisha(new Date());
    }

    @Override
    public List<Film> search(String name) {
        return filmsRepository.findAllByNameContainsIgnoreCase(name);
    }
}
