package ru.itis.moviehub.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.moviehub.models.User;
import ru.itis.moviehub.security.details.UserDetailsImpl;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String getChatPage(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        return "chat";
    }
}
