package ru.gb.lesson9.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gb.lesson9.domains.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
