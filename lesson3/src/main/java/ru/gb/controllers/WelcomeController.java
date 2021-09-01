package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }

    @GetMapping("/test")
    public String indexTestS(Model model) {
        model.addAttribute("message", "Hello World - test");
        return "index";
    }

}
