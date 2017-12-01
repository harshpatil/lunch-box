package com.passion.lunchbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetails {

    private String orderId;
    private String userId;
    private double price;
}
