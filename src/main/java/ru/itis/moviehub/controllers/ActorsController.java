package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.moviehub.models.Actor;
import ru.itis.moviehub.services.ActorsService;

import java.util.List;

@Controller
public class ActorsController {

    @Autowired
    ActorsService actorsService;

    @GetMapping("/actors")
    public String getActors(Model model) {
        List<Actor> actors = actorsService.getActors();
        model.addAttribute("actors", actors);
        return "actors";
    }
}
//
//    @Override
//    public UserDto getConcreteUser(Long userId) {
//        User user = usersRepository.getOne(userId);
//        return from(user);
//    }
//
//    @Override
//    public List<UserDto> search(String name) {
//        return from(usersRepository.findAllByNameContainsIgnoreCase(name));
//    }
