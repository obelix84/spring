package ru.gb.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            products.add(new Product(i, "Product" + i, i*100f));
        }
    }

    public Optional<Product> getProduct(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst();
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public List<Product> getAll() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }
}