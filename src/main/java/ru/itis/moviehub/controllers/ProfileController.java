package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.moviehub.models.Checklist;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.security.details.UserDetailsImpl;
import ru.itis.moviehub.services.ChecklistsService;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ChecklistsService checklistsService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        List<Checklist> checklists = checklistsService.getChecklists(user);
        model.addAttribute("user", user);
        model.addAttribute("checklists", checklists);
        return "profile";
    }
}
