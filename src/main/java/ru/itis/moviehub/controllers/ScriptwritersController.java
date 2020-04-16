package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.moviehub.models.Scriptwriter;
import ru.itis.moviehub.services.ScriptwritersService;

import java.util.List;

@Controller
@RequestMapping("/scriptwriters")
public class ScriptwritersController {

    @Autowired
    ScriptwritersService scriptwritersService;

    @GetMapping
    public String getScriptwriters(Model model) {
        List<Scriptwriter> scriptwriters = scriptwritersService.getScriptwriters();
        model.addAttribute("scriptwriters", scriptwriters);
        return "scriptwriters";
    }

    @GetMapping("/{scriptwriter-id}")
    public String getConcreteUserPage(@PathVariable("scriptwriter-id") Long scriptwriterId, Model model) {
        Scriptwriter scriptwriter = scriptwritersService.getConcreteScriptwriter(scriptwriterId);
        model.addAttribute("star", scriptwriter);
        return "star";
    }
}
