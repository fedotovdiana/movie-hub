package ru.itis.moviehub.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignIn(Authentication authentication, @RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }
        if (authentication != null) {
            return "redirect:/profile";
        }
        return "sign_in";
    }
}

//    @Autowired
//    private SignInService signInService;
//    @PostMapping("/signIn")
//    public String signIn(@RequestParam("login") String login,
//                         @RequestParam("password") String password,
//                         @RequestParam(value = "check", required = false) String check,
//                         HttpServletResponse response) {
//        Boolean isNeedCookie = check != null;
//        String cookieValue = signInService.signIn(login, password, isNeedCookie);
//        System.out.println(isNeedCookie);
//
//        if (cookieValue == null) {
//            return "redirect:/signIn?error";
//        }
//        if (isNeedCookie) {
//            Cookie cookie = new Cookie("AuthCookie", cookieValue);
//            response.addCookie(cookie);
//            System.out.println("NEEDCOOKIE");
//        }
//        System.out.println("END SIGNIN");
//        return "redirect:/films";
//    }
