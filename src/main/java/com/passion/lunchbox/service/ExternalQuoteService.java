package com.passion.lunchbox.service;

import com.passion.lunchbox.model.CreateUserRequest;
import com.passion.lunchbox.model.CreateUserResponse;
import com.passion.lunchbox.model.Quote;
import com.passion.lunchbox.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalQuoteService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private RestTemplate restTemplate;

    @Autowired
    public ExternalQuoteService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<Object> getRandomQuote(){
        try{
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            return new ResponseEntity<>(quote, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in getting Quote {}", e);
            return new ResponseEntity<>(new ApiError("Error in getting Quote"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getRandomQuoteValue(){
        try{
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            return new ResponseEntity<>(quote.getValue(), HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in getting Quote value {}", e);
            return new ResponseEntity<>(new ApiError("Error in getting Quote value"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> createUser(CreateUserRequest createUserRequest){
        try{
            CreateUserResponse createUserResponse = restTemplate.postForObject("http://localhost:8080/user", createUserRequest, CreateUserResponse.class);
            return new ResponseEntity<>(createUserResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in creating user {}", e);
            return new ResponseEntity<>(new ApiError("Error in creating user"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> createUserUsingHeader(CreateUserRequest createUserRequest){
        try{
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", "application/json");

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            HttpEntity<CreateUserRequest> request = new HttpEntity<>(createUserRequest, headers);

            CreateUserResponse createUserResponse = restTemplate.postForObject("http://localhost:8080/user", request, CreateUserResponse.class);
            return new ResponseEntity<>(createUserResponse, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in creating user {}", e);
            return new ResponseEntity<>(new ApiError("Error in creating user"), HttpStatus.BAD_REQUEST);
        }
    }
}
