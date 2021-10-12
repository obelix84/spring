package ru.gb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.entity.Cart;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
