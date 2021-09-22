package ru.gb.lesson7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.lesson7.domain.Good;

@Repository
public interface GoodsRepository extends CrudRepository<Good, Integer> {
}
