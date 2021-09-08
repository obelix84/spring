package ru.gb.repository;

import org.springframework.stereotype.Repository;
import ru.gb.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
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

    public void remove(int id) {
        Product product = getProduct(id).orElseThrow(null);
        this.products.remove(product);
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }
}