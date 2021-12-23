package ua.kharin.springdemo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import ua.kharin.springdemo.dto.User;
import ua.kharin.springdemo.service.UsersService;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    @GetMapping("/users/add")
    public String getAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @GetMapping("/users/{id}/edit")
    public String getEditUserPage(Model model, @PathVariable Long id) {
        if (!usersService.isExists(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
        User user = usersService.getUser(id).get();
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/users/add")
    public String doCreateUser( @ModelAttribute("user") User user,
                               BindingResult bindingResult,
                               Model model) {
        usersService.saveUser(user);
        return "redirect:/ui/users";
    }

    @PostMapping("/users/{id}/edit")
    public String doUpdateUser( @ModelAttribute("user") User user,
                               BindingResult bindingResult,
                               Model model) {
        usersService.saveUser(user);
        return "redirect:/ui/users";
    }

    @GetMapping("/users/{id}/delete")
    public String doDeleteUser(@PathVariable long id) {
        usersService.deleteUser(id);
        return "redirect:/ui/users";
    }
}
