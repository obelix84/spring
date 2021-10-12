package ru.gb.lesson9.domains;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    long id;
    long user_id;
    @ManyToMany
    List<Product> products;

    public Cart(long id, long user_id, List<Product> products) {
        this.id = id;
        this.user_id = user_id;
        this.products = products;
    }
}
