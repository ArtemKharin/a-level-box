package ua.kharin.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kharin.springdemo.dto.User;
import ua.kharin.springdemo.service.UsersService;

import java.util.List;

@RestController
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }
}
