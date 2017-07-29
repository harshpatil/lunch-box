package com.passion.lunchbox.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Users {

    private Integer count;
    private List<User> userList;
}
