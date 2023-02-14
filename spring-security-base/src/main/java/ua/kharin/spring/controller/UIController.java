package ua.kharin.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
