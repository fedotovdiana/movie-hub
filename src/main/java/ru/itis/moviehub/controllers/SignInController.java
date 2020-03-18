package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.moviehub.services.SignInService;
import ru.itis.moviehub.services.SignInServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {

    @Autowired
    private SignInService signInService;

    @GetMapping("/signIn")
    public String getSignIn(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "sign_in";
    }

    @PostMapping("/signIn")
    public String signIn(@RequestParam("login") String login,
                         @RequestParam("password") String password,
                         HttpServletResponse response) {
        String cookieValue = signInService.signIn(login, password);

        if (cookieValue == null) {
            return "redirect:/signIn?error";
        }

        Cookie cookie = new Cookie("AuthCookie", cookieValue);
        response.addCookie(cookie);
        return "redirect:/users";
    }
}
