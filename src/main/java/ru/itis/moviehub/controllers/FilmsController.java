package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.services.FilmsService;

import java.util.List;

@Controller
@RequestMapping("films")
public class FilmsController {

    @Autowired
    FilmsService filmsService;

    @GetMapping
    public String getFilms(Model model) {
        List<Film> films = filmsService.getFilms();
        model.addAttribute("films", films);
        return "films";
    }

    @GetMapping("/{film-id}")
    public String getConcreteFilm(@PathVariable("film-id") Integer filmId, Model model) {
        Film film = filmsService.getConcreteFilm(filmId);
        model.addAttribute("film", film);
        return "film";
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/search", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Film> searchFilms(@RequestParam("name") String name) {
        return filmsService.search(name);
    }
}
