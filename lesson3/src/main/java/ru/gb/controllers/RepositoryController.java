package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.beans.Order;
import ru.gb.beans.Product;
import ru.gb.beans.ProductRepository;

import java.util.List;

@Controller
public class RepositoryController {

    private ProductRepository repository;

    public RepositoryController(ProductRepository repository) {
        this.repository = repository;
    }

    @ModelAttribute("allProducts")
    public List<Product> getAll() {
        return this.repository.getAll();
    }

    @GetMapping("/repository")
    public String showProducts() {
        return "repository";
    }

    @RequestMapping(value = "/repository/add", method = RequestMethod.POST)
    public String add(Product product) {
        repository.add(product);
        return "repository";
    }

    @RequestMapping(value = "/repository/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "repository-add";
    }

}
