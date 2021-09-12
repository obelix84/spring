package ru.gb.products;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    //ru.gb.products.Product (Long id, String title, int price)
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "title", length = 100)
    private String title;
    //по заданию INT
    @Column(name = "price")
    private int price;

    public Product() {
    }

    public Product(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
