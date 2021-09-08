package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.beans.Order;
import ru.gb.beans.OrderRepository;
import ru.gb.beans.Product;

import java.util.List;

@Controller
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String add(Order order) {
        repository.add(order);
        return "orders";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("order", new Order());
        return "orders-add";
    }

    @ModelAttribute("allOrders")
    public List<Order> getAll() {
        return this.repository.getAll();
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String add() {
        return "orders";
    }


}
