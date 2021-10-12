package ru.gb.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.Category;
import ru.gb.entity.Product;
import ru.gb.repository.CartRepository;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository prodRepo;

    public ProductController(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Product> products = new ArrayList<>();
        prodRepo.findAll().forEach(products::add);
        model.addAttribute("products", products);
        return "products/products-all";
    }

    @Secured({"ADMIN", "MANAGER"})
    @GetMapping("/add")
    public String addForm(Product product) {
        return "products/products-add";
    }

    @Secured({"ADMIN", "MANAGER"})
    @PostMapping("/add")
    public String add(Product product) {
        prodRepo.save(product);
        return "redirect:products";
    }

}