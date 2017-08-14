package com.passion.lunchbox.model;

import com.passion.lunchbox.dto.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Users {

    private Integer count;
    private List<User> userList;
}
