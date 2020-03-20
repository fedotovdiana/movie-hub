package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.services.FilmsService;

import java.util.List;

@Controller
@RequestMapping("/afisha")
public class AfishaController {

    @Autowired
    FilmsService filmsService;

    @GetMapping
    public String getAfisha(Model model) {
        List<Film> films = filmsService.getAfisha();
        model.addAttribute("films", films);
        return "afisha";
    }
}
