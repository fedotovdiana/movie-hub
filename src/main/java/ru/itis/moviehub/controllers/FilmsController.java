package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.security.details.UserDetailsImpl;
import ru.itis.moviehub.services.FilmsService;
import ru.itis.moviehub.services.LikesService;

import java.util.List;

@Controller
@RequestMapping("films")
public class FilmsController {

    @Autowired
    FilmsService filmsService;

    @Autowired
    LikesService likesService;

    @GetMapping
    public String getFilms(Model model) {
        List<Film> films = filmsService.getFilms();
        model.addAttribute("films", films);
        return "films";
    }

    @GetMapping("/{film-id}")
    public String getConcreteFilm(@PathVariable("film-id") Integer filmId, Authentication authentication, Model model) {
        User user = null;
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            user = userDetails.getUser();
        }
        Film film = filmsService.getConcreteFilm(filmId);
        Long likes = likesService.getLikes(filmId);
        Long dislikes = likesService.getDislikes(filmId);
        model.addAttribute("user", user);
        model.addAttribute("film", film);
        model.addAttribute("likes", likes);
        model.addAttribute("dislikes", dislikes);
        return "film";
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/search", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Film> searchFilms(@RequestParam("name") String name) {
        return filmsService.search(name);
    }

    @PostMapping(path = "/like")
    public void addLike(@RequestParam("film_id") Integer filmId, Authentication authentication) {
        System.out.println(filmId + "ddddddddddddddd");
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Film film = filmsService.getConcreteFilm(filmId);
        likesService.addLike(user, film);
    }

    @PostMapping(path = "/dislike")
    public void addDislike(@RequestParam("film_id") Integer filmId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Film film = filmsService.getConcreteFilm(filmId);
        likesService.addDislike(user, film);
    }
}
