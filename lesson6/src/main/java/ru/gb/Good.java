package ru.gb;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private float cost;


    @ManyToMany
    @JoinTable(
            name = "customers_goods",
            joinColumns = @JoinColumn(name = "good_id"),
            inverseJoinColumns = @JoinColumn(name = "cust_id")
    )
    List<Customer> customers;

    public Good() {
    }

    public Good(int id, String name, float cost, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }


}
