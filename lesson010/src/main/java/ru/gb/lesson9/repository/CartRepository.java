package ru.gb.lesson9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson9.domains.Cart;


@Repository
public interface CartRepository extends CrudRepository<Cart, Long>  {
}
