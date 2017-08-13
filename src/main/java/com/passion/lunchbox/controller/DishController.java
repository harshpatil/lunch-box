package com.passion.lunchbox.controller;

import com.passion.lunchbox.model.Dish;
import com.passion.lunchbox.service.DishService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class DishController {

    @Autowired
    DishService dishService;

    @ApiOperation(value = "Add Menu", notes = "Add a menu item")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addMenu(@RequestBody Dish dish){
        return dishService.postDish(dish);
    }

    @ApiOperation(value = "Get all dishes", notes = "returns all the dishes")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllDishes(){
        return dishService.getDishes();
    }
}
