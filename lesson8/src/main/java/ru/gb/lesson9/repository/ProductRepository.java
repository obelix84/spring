package ru.gb.lesson9.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.lesson9.domains.Product;


//public interface ProductRepository extends CrudRepository<Product, Long> {
//
//}

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
