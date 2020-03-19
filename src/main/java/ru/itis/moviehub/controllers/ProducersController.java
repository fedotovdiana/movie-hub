package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.moviehub.models.Producer;
import ru.itis.moviehub.services.ProducersService;

import java.util.List;

@RequestMapping("/producers")
@Controller
public class ProducersController {

    @Autowired
    ProducersService producersService;

    @GetMapping
    public String getProducers(Model model) {
        List<Producer> producers = producersService.getProducers();
        model.addAttribute("producers", producers);
        return "producers";
    }

    @GetMapping("/{producer-id}")
    public String getConcreteProducer(@PathVariable("producer-id") Integer producerId, Model model) {
        Producer producer = producersService.getConcreteProducer(producerId);
        model.addAttribute("star", producer);
        return "star";
    }
}
