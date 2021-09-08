package ru.gb.repository;

import org.springframework.stereotype.Repository;
import ru.gb.domain.Order;
import ru.gb.domain.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    private List<Order> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
        orders.add(new Order(1, LocalDate.now(), 65.43f, Collections.emptyList()));
    }

    public Optional<Order> getOrder(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst();
    }

    public List<Order> getAll() {
        return orders;
    }

    public void add(Order order) {
        orders.add(order);
    }

    public void remove(int id) {
        Order order = getOrder(id).orElseThrow(null);
        this.orders.remove(order);
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
