package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.Film;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.security.details.UserDetailsImpl;
import ru.itis.moviehub.services.ChecklistsService;

import java.util.List;

@Controller
@RequestMapping("/checklists")
public class ChecklistsController {

    @Autowired
    ChecklistsService checklistsService;

    @GetMapping("/{checklist-id}")
    public String getConcreteChecklist(@PathVariable("checklist-id") Long id, Model model) {
        Checklist checklist = checklistsService.getChecklist(id);
        List<Film> films = checklistsService.getFilms(id);
        model.addAttribute("checklist", checklist);
        model.addAttribute("films", films);
        return "checklist";
    }

    @PostMapping("/add-to-new")
    @ResponseBody
    public void addFilmToNewChecklist(@RequestParam("name") String name, @RequestParam("film_id") Long filmId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        checklistsService.addFilmToNew(name, user.getId(), filmId);
    }

    @PostMapping("/add-to")
    @ResponseBody
    private void addFilmToChecklist(@RequestParam("name") String name, @RequestParam("film_id") Long filmId) {
        checklistsService.addFilmTo(name, filmId);
    }

    @PostMapping("/delete")
    @ResponseBody
    private void deleteChecklist(@RequestParam("checklist_id") Long id) {
        checklistsService.deleteChecklist(id);
    }

    @PostMapping("/delete-film")
    @ResponseBody
    private void deleteChecklist(@RequestParam("film_id") Long filmIid, @RequestParam("checklist_id") Long checklistId) {
        checklistsService.deleteFilmFrom(checklistId, filmIid);
    }
}
