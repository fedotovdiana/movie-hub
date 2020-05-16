package ru.itis.moviehub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.moviehub.dto.SignUpForm;
import ru.itis.moviehub.services.SignUpService;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model) {
        model.addAttribute("form", new SignUpForm());
            return "sign_up";
    }

    @PostMapping("/signUp")
    public String updateProfile(@Valid @ModelAttribute("form") SignUpForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(form);
            System.out.println("ERRORS: " + bindingResult.getAllErrors());
            model.addAttribute("form", form);
            return "sign_up";
        } else {
            service.signUp(form);
            return "redirect:/signIn";
        }
    }
}
