package ru.gb.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
        orders.add(new Order(1, LocalDate.now(), 65.43f, Collections.emptyList()));
    }

    public Optional<Order> getProduct(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst();
    }

    public List<Order> getAll() {
        return orders;
    }

    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
