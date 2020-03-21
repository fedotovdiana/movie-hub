package ru.itis.moviehub.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    @PreAuthorize("permitAll()")
    @GetMapping
    public String getRootPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/profile";
        } else {
            return "redirect:/signIn";
        }
    }
}
