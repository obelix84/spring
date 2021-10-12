package ru.gb.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor

public class Cart {
    @Id
    @GeneratedValue
    long id;
    @ManyToMany
    List<Product> Products;
    //считаем, что у каждого пользователя только одна корзина
    @OneToOne
    User user;
}