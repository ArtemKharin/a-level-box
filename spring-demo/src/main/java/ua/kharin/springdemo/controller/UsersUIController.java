package ua.kharin.springdemo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kharin.springdemo.dto.User;
import ua.kharin.springdemo.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/ui")
public class UsersUIController {
    private final UsersService usersService;
    private final Logger log = LogManager.getLogger(UsersUIController.class);

    public UsersUIController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = usersService.getAllUsers();
        log.info("List of users: {}", users);
        model.addAttribute("users", users);
        return "users";
    }
}
