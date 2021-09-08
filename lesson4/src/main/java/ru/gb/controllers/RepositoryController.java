package ru.gb.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.Product;
import ru.gb.repository.ProductRepository;


import java.util.List;

@Controller
@RequestMapping("/products")
public class RepositoryController {

    private final ProductRepository repository;

    public RepositoryController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findAll() {
        return repository.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product findById(@PathVariable int id) {
        return repository.getProduct(id).orElseThrow();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        repository.remove(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Product> save(@RequestBody Product product) {
        repository.add(product);
        return repository.getAll();
    }

}