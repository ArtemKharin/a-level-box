package ua.kharin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kharin.springdemo.controller.model.CreateUserRequest;
import ua.kharin.springdemo.controller.model.User;
import ua.kharin.springdemo.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user/{userId}")
    public User getUserByID(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @RequestMapping(path = "/user/list", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping(path = "/user")
    public User createUserUsingParams(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam(defaultValue = "Kh") String city) {
        User user = new User(firstName, lastName, city);
        return userService.save(user);
    }

    @PostMapping(path = "v2/user")
    public User createUserUsingBody(@RequestBody CreateUserRequest request) {
        User user = new User(request.getFirstName(), request.getLastName(), request.getCity());
        return userService.save(user);
    }

    @DeleteMapping(path = "/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.status(204).build();
    }
}
