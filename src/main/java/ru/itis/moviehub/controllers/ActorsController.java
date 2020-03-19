package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.moviehub.models.Actor;
import ru.itis.moviehub.services.ActorsService;

import java.util.List;

@Controller
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    ActorsService actorsService;

    @GetMapping
    public String getActors(Model model) {
        List<Actor> actors = actorsService.getActors();
        model.addAttribute("actors", actors);
        return "actors";
    }

    @GetMapping("/{actor-id}")
    public String getConcreteActor(@PathVariable("actor-id") Integer actorId, Model model) {
        Actor actor = actorsService.getConcreteActor(actorId);
        model.addAttribute("star", actor);
        return "star";
    }
}
