package com.passion.lunchbox.service;

import com.passion.lunchbox.dto.Dish;
import com.passion.lunchbox.model.Dishes;
import com.passion.lunchbox.repository.DishRepository;
import com.passion.lunchbox.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DishRepository dishRepository;

    public ResponseEntity<Object> getDishes(){
        try {
            Dishes dishes = new Dishes();
            dishes.setDishList(dishRepository.findAll());
            dishes.setCount(dishes.getDishList().size());
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiError("Error in getting dishes"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> postDish(Dish dish){
        try {
            dishRepository.save(dish);
            return new ResponseEntity<>(dish, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiError("Error in saving to DB"), HttpStatus.BAD_REQUEST);
        }
    }
}
