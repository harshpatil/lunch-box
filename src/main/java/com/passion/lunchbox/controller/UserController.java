package com.passion.lunchbox.controller;

import com.passion.lunchbox.model.Quote;
import com.passion.lunchbox.model.User;
import com.passion.lunchbox.model.Users;
import com.passion.lunchbox.model.Value;
import com.passion.lunchbox.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "Add a user", notes = "Add a user")
    @PostMapping()
    public @ResponseBody
    User addAUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }

    @ApiOperation(value = "Get All Users", notes = "Get all users")
    @GetMapping()
    public @ResponseBody Users getUsers(){
        Users users = new Users();
        users.setUserList(userRepository.findAll());
        users.setCount(users.getUserList().size());
        return users;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @ApiOperation(value = "Get random quote", notes = "return random quote")
    @GetMapping(path="quote")
    public @ResponseBody Quote getRandomQuote(RestTemplate restTemplate){
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote;
    }

    @ApiOperation(value = "Get quote value", notes = "get quote value")
    @GetMapping(path="quoteValue")
    public @ResponseBody
    Value getQuoteValue(RestTemplate restTemplate){
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        return quote.getValue();
    }

    @ApiOperation(value = "test Post", notes = "test Post")
    @PostMapping(path="testPost")
    public @ResponseBody User testPost(RestTemplate restTemplate){

        User user = new User();
        user.setEmailId("harsh.00.patil@gmail.com");
        user.setPhoneNumber(9916133076l);
        user.setUserName("Patil");
        return restTemplate.postForObject("http://localhost:8080/user", user, User.class);
    }

    @ApiOperation(value = "test Post with header", notes = "test post woth header")
    @PostMapping(path="testPostWithHeaders")
    public @ResponseBody User testPostWithHeaders(RestTemplate restTemplate){

        User user = new User();
        user.setEmailId("harsh.patil@gmail.com");
        user.setPhoneNumber(9916133076l);
        user.setUserName("Patil");

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<User> request = new HttpEntity<User>(user, headers);

        return restTemplate.postForObject("http://localhost:8080/user", request, User.class);
    }
}
