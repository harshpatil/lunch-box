package com.passion.lunchbox.repository;

import com.passion.lunchbox.dto.User;
import com.passion.lunchbox.model.CreateUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    User findById(String id);
    User findByPhoneNumber(Long phoneNumber);
}
