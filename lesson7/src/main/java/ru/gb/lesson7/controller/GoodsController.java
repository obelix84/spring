package ru.gb.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson7.domain.Good;
import ru.gb.lesson7.repository.GoodsRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsRepository repository;

    public GoodsController(GoodsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Good findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Good> findAll() {
        List<Good> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Good> save(@RequestBody Good good) {
        repository.save(good);
        List<Good> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }


}
