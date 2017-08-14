package com.passion.lunchbox.controller;

import com.passion.lunchbox.model.CreateUserRequest;
import com.passion.lunchbox.service.ExternalQuoteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/quote", produces= MediaType.APPLICATION_JSON_VALUE)
public class ExternalQuoteController {

    @Autowired
    ExternalQuoteService externalQuoteService;

    @ApiOperation(value = "Get random quote", notes = "return random quote")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getRandomQuote(){
        return externalQuoteService.getRandomQuote();
    }

    @ApiOperation(value = "Get quote value", notes = "get quote value")
    @RequestMapping(path = "/value", method = RequestMethod.GET)
    public ResponseEntity<Object> getQuoteValue(){
        return externalQuoteService.getRandomQuoteValue();
    }

    @ApiOperation(value = "test Post", notes = "test Post")
    @PostMapping(path="testPost")
    public ResponseEntity<Object> testPost(@RequestBody CreateUserRequest createUserRequest){
        return externalQuoteService.createUser(createUserRequest);
    }

    @ApiOperation(value = "test Post with header", notes = "test post woth header")
    @PostMapping(path="testPostWithHeaders")
    public ResponseEntity<Object> testPostWithHeaders(@RequestBody CreateUserRequest createUserRequest){
        return externalQuoteService.createUserUsingHeader(createUserRequest);
    }

}
