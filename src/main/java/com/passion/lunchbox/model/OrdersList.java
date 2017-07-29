package com.passion.lunchbox.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OrdersList {

    private Integer count;
    private List<Orders> listOfOrders;
}
