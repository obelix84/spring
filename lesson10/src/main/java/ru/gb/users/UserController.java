package ru.gb.users;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.goods.Good;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users/mvc")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @Secured("ADMIN")
    public String getAllUsers(Model model) {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        model.addAttribute("users", users);
        return "users-all";
    }
}
