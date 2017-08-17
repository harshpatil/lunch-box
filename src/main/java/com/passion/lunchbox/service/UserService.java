package com.passion.lunchbox.service;

import com.passion.lunchbox.dto.User;
import com.passion.lunchbox.model.CreateUserRequest;
import com.passion.lunchbox.model.CreateUserResponse;
import com.passion.lunchbox.model.UpdatePasswordRequest;
import com.passion.lunchbox.repository.UserRepository;
import com.passion.lunchbox.util.ApiError;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> addUser(CreateUserRequest createUserRequest){
        try {
            if(userRepository.findByPhoneNumber(createUserRequest.getPhoneNumber()) != null){
                return new ResponseEntity<>(new ApiError("User already exists with phone number :: "
                        + createUserRequest.getPhoneNumber()), HttpStatus.CONFLICT);
            }
            String userId = UUID.randomUUID().toString();
            String password = DigestUtils.sha1Hex(createUserRequest.getPassword());
            User user = new User(userId.toString(), createUserRequest.getFirstName(), createUserRequest.getLastName(),
                    createUserRequest.getEmailId(), createUserRequest.getPhoneNumber(),
                    password);
            userRepository.save(user);
            user = userRepository.findById(userId);
            CreateUserResponse createUserResponse = new CreateUserResponse(user.getId(),
                    user.getFirstName(), user.getLastName(), user.getEmailId(),
                    user.getPhoneNumber());
            return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
        } catch (Exception e){
            log.error("Error in creating user {}", e);
            return new ResponseEntity<>(new ApiError("Error in creating user"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getUser(String userId){
        try{
            User user = userRepository.findById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in getting user {}", e);
            return new ResponseEntity<>(new ApiError("Error in getting user"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getAllUsers(){
        try{
            List<User> userList = userRepository.findAll();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }catch (Exception e){
            log.error("Error in getting users {}", e);
            return new ResponseEntity<>(new ApiError("Error in getting users"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> updatePassword(String userId, UpdatePasswordRequest updatePasswordRequest){
        try {
            if(userRepository.findById(userId) == null){
                return new ResponseEntity<>(new ApiError("User " + userId + " doesn't exist"),
                        HttpStatus.NOT_FOUND);
            }
            String password = DigestUtils.sha1Hex(updatePasswordRequest.getPassword());
            userRepository.updatePassword(userId, password);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            log.error("Error in updating password {}", e);
            return new ResponseEntity<>(new ApiError("Error in updating password"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> deleteUser(String userId){
        try {
            if(userRepository.findById(userId) == null){
                return new ResponseEntity<>(new ApiError("User " + userId + " doesn't exist"),
                        HttpStatus.NOT_FOUND);
            }
            userRepository.removeById(userId);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e){
            log.error("Error in updating password {}", e);
            return new ResponseEntity<>(new ApiError("Error in updating password"), HttpStatus.BAD_REQUEST);
        }
    }
}
