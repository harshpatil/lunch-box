package com.passion.lunchbox.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String orderId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User userId;
    private String userId;

    private double price;
}
