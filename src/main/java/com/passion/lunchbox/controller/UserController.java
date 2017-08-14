package com.passion.lunchbox.controller;

import com.passion.lunchbox.model.CreateUserRequest;
import com.passion.lunchbox.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "/user", produces= MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Add a user", notes = "Add a user")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addAUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.addUser(createUserRequest);
    }

    @ApiOperation(value = "Get All Users", notes = "Get all users")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers(){
        return userService.getAllUsers();
    }
}
