package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.moviehub.dto.SignUpDto;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.security.details.UserDetailsImpl;
import ru.itis.moviehub.services.UsersService;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public String getProfile(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "settings";
    }

    @PostMapping
    public String signUp(Authentication authentication, SignUpDto form) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        usersService.updateUser(form, user.getId());
        return "redirect:/profile";
    }
}
