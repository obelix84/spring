package ru.gb.web;


import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.entity.Category;
import ru.gb.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Category> categories = new ArrayList<>();
        repository.findAll().forEach(categories::add);

        model.addAttribute("categories", categories);
        return "category/category-all";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("category", repository.findById(id).get());
        return "category/category-current";
    }

    @Secured("ADMIN")
    @GetMapping("/add")
    public String addForm(Category category) {
        return "category/category-add";
    }

    @Secured("ADMIN")
    @PostMapping("/add")
    public String add(Category category) {
        repository.save(category);
        return "redirect:/categories";
    }

}
