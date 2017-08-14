package com.passion.lunchbox.repository;

import com.passion.lunchbox.dto.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

    Orders findByOrderId(String orderId);
    List<Orders> findByUserId(String userId);
}
