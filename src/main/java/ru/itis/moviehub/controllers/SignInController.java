package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.moviehub.services.SignInService;

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
                         @RequestParam(value = "check", required = false) String check,
                         HttpServletResponse response) {
        Boolean isNeedCookie = check != null;
        String cookieValue = signInService.signIn(login, password, isNeedCookie);

        if (cookieValue == null) {
            return "redirect:/signIn?error";
        }
        if (isNeedCookie) {
            Cookie cookie = new Cookie("AuthCookie", cookieValue);
            response.addCookie(cookie);
        }
        return "redirect:/users";
    }
}
