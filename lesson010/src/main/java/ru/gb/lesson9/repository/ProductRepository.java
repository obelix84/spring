package ru.gb.lesson9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson9.domains.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
