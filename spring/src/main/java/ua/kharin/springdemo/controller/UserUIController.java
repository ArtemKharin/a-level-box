package ua.kharin.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ua.kharin.springdemo.controller.model.User;
import ua.kharin.springdemo.service.UserService;

@Controller
@RequestMapping("/ui/users/")
public class UserUIController {
    private final UserService userService;

    @Autowired
    public UserUIController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsersSummary(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("{userId}/edit")
    public String getEditUserPage(@PathVariable Long userId,
                                  Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "editUser";
    }

    @GetMapping("/add")
    public String getAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("{userId}/edit")
    public RedirectView editUser(@PathVariable Long userId,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam(defaultValue = "Kh") String city) {
        User user = new User(userId, firstName, lastName, city);
        userService.save(user);
        return new RedirectView("/ui/users/");
    }

    @PostMapping("add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/ui/users/";
    }

    @GetMapping("{userId}/delete")
    public String removeUser(@PathVariable Long userId,
                             Model model) {
        userService.delete(userId);
        model.addAttribute("userId", userId);
        return "removed";
    }
}
