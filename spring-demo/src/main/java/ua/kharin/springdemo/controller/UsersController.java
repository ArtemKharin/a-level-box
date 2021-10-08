package ua.kharin.springdemo.controller;

import org.springframework.web.bind.annotation.*;
import ua.kharin.springdemo.dto.User;
import ua.kharin.springdemo.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getAllUsers();
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable long userId) {
        if (usersService.isExists(userId)) {
            usersService.deleteUser(userId);
        }
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        usersService.saveUser(user);
    }
}
