package ua.kharin.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kharin.springdemo.service.UsersService;

@Controller
@RequestMapping("/ui")
public class UsersUIController {
    private final UsersService usersService;

    public UsersUIController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }
}
