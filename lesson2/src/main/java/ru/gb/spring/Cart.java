package ru.gb.spring;

import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ProductRepository repository;
    private List<Product> products;

    public Cart(ProductRepository repository) {
        this.repository = repository;
        products = new ArrayList<>();
    }

    public List<Product> getContents(){
        return products;
    }

    public void add(int id) {
        repository.getProduct(id).ifPresent(prod -> products.add(prod));
    }

    public void remove(int id) {
        repository.getProduct(id).ifPresent(prod -> products.remove(prod));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "repository=" + repository +
                ", products=" + products +
                '}';
    }
}
