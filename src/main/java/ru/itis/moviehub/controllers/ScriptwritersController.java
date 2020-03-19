package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.moviehub.models.Scriptwriter;
import ru.itis.moviehub.services.ScriptwritersService;

import java.util.List;

@Controller
public class ScriptwritersController {

    @Autowired
    ScriptwritersService scriptwritersService;

    @GetMapping("/scriptwriters")
    public String getScriptwriters(Model model) {
        List<Scriptwriter> scriptwriters = scriptwritersService.getScriptwriters();
        model.addAttribute("scriptwriters", scriptwriters);
        return "scriptwriters";
    }
}
