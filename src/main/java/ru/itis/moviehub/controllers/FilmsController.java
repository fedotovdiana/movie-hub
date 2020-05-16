package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.moviehub.dto.FilmSearchResult;
import ru.itis.moviehub.models.*;
import ru.itis.moviehub.security.details.UserDetailsImpl;
import ru.itis.moviehub.services.*;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    FilmsService filmsService;

    @Autowired
    LikesService likesService;

    @Autowired
    ChecklistsService checklistsService;

    @Autowired
    ActorsService actorsService;

    @Autowired
    ScriptwritersService scriptwritersService;

    @Autowired
    ProducersService producersService;

    @GetMapping
    public String getFilms(Model model) {
        List<Film> films = filmsService.getFilms();
        model.addAttribute("films", films);
        return "films";
    }

    @GetMapping("/{film-id}")
    public String getConcreteFilm(@PathVariable("film-id") Long filmId, Authentication authentication, Model model) {
        List<Checklist> checklists = null;
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            User user = userDetails.getUser();
            checklists = checklistsService.getChecklists(user.getId());
            model.addAttribute("user", user);
        }
        Film film = filmsService.getConcreteFilm(filmId);
        Long likes = likesService.getLikes(filmId);
        Long dislikes = likesService.getDislikes(filmId);
        List<Actor> actors = actorsService.getActorsByFilm(filmId);
        List<Producer> producers = producersService.getProducersByFilm(filmId);
        List<Scriptwriter> scriptwriters = scriptwritersService.getScriptwritersByFilm(filmId);
        model.addAttribute("film", film);
        model.addAttribute("likes", likes);
        model.addAttribute("dislikes", dislikes);
        model.addAttribute("checklists", checklists);
        model.addAttribute("actors", actors);
        model.addAttribute("producers", producers);
        model.addAttribute("scriptwriters", scriptwriters);
        return "film";
    }

    @GetMapping(path = "/search")
    @ResponseBody
    public FilmSearchResult searchFilms(@RequestParam("query") String query,
                                        @RequestParam("page") Integer page,
                                        @RequestParam("size") Integer size) {
        return filmsService.search(query, page, size);
    }

    @PostMapping(path = "/like")
    @ResponseBody
    public void addLike(@RequestParam("film_id") Long filmId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Film film = filmsService.getConcreteFilm(filmId);
        likesService.addLike(user, film);
    }

    @PostMapping(path = "/dislike")
    @ResponseBody
    public void addDislike(@RequestParam("film_id") Long filmId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        Film film = filmsService.getConcreteFilm(filmId);
        likesService.addDislike(user, film);
    }
}
