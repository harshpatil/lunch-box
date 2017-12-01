package com.passion.lunchbox.repository;

import com.passion.lunchbox.dto.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    Orders findByOrderId(String orderId);
    List<Orders> findByUserId(String userId);
}
