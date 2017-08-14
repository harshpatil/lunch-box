package com.passion.lunchbox.repository;

import com.passion.lunchbox.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.passion.lunchbox.constant.ConstantQueries.updatePasswordQuery;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    User findById(String id);
    User findByPhoneNumber(Long phoneNumber);

    @Modifying
    @Transactional
    @Query(value = updatePasswordQuery)
    void updatePassword(String id, String password);

    @Modifying
    @Transactional
    void removeById(String id);
}
