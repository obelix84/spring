package ru.gb.lesson9.domains;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name", length = 45)
    @NotBlank(message = "Name is NOT NULL")
    private String name;
    @Column(name = "price")
    @NotNull(message = "Price is NOT NULL")
    @Positive
    private float price;

    public Product() {
    }

    public Product(String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}