package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.repository.OrderRepository;
import ru.gb.domain.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Order> findAll() {
        return repository.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order findById(@PathVariable int id) {
        return repository.getOrder(id).orElseThrow();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        repository.remove(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Order> save(@RequestBody Order order) {
        repository.add(order);
        return repository.getAll();
    }

}
