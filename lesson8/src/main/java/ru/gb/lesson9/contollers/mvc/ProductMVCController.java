package ru.gb.lesson9.contollers.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson9.contollers.rest.ProductError;
import ru.gb.lesson9.domains.Product;
import ru.gb.lesson9.repository.ProductRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products/mvc")
public class ProductMVCController {
    private final ProductRepository repository;

    public ProductMVCController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable long id) {
        repository.deleteById(id);
        return "redirect:/products/mvc";
    }

    @GetMapping("/form")
    public String saveForm(Product product) {
        return "product-add";
    }


    @PostMapping
    public String save(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product-add";
        }
        repository.save(product);
        return "redirect:/products/mvc";
    }

    //очень упрощенно, но пусть бужет
    @ExceptionHandler
    public String handleException(RuntimeException ex) {
        return "product-err";
    }

}