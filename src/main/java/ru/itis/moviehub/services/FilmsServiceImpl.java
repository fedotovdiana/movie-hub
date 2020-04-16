package ru.itis.moviehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.moviehub.dto.FilmSearchResult;
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
    public Film getConcreteFilm(Long id) {
        return filmsRepository.getOne(id);
    }

    @Override
    public List<Film> getAfisha() {
        return filmsRepository.findAfisha(new Date());
    }

    @Override
    public FilmSearchResult search(String query, Integer page, Integer size) {
        filmsRepository.findAllByNameContainsIgnoreCase(query);
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Film> pageResult = filmsRepository.search(query, pageRequest);
        List<Film> films = pageResult.getContent();
        return FilmSearchResult.builder()
                .films(films)
                .count(pageResult.getTotalPages())
                .build();
    }

    @Override
    public List<Film> getTopFilms() {
        return filmsRepository.findTopFilms();
    }

}
