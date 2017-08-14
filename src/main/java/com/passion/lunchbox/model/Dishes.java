package com.passion.lunchbox.model;

import com.passion.lunchbox.dto.Dish;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Dishes {

    private Integer count;
    private List<Dish> dishList;
}
