package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.moviehub.models.Producer;
import ru.itis.moviehub.services.ProducersService;

import java.util.List;

@Controller
public class ProducersController {

    @Autowired
    ProducersService producersService;

    @GetMapping("/producers")
    public String getProducers(Model model) {
        List<Producer> producers = producersService.getProducers();
        model.addAttribute("producers", producers);
        return "producers";
    }
}
