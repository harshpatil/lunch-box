package com.passion.lunchbox.model;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private String userId;
    private long price;
}
