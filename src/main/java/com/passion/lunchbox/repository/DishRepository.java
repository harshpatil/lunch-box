package com.passion.lunchbox.repository;

import com.passion.lunchbox.model.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish, Long> {

    List<Dish> findAll();
}
