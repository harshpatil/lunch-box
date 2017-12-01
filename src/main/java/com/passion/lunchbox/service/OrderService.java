package com.passion.lunchbox.service;

import com.passion.lunchbox.dto.Orders;
import com.passion.lunchbox.model.CreateOrderRequest;
import com.passion.lunchbox.model.OrderDetails;
import com.passion.lunchbox.model.OrdersList;
import com.passion.lunchbox.repository.OrdersRepository;
import com.passion.lunchbox.util.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrdersRepository ordersRepository;

    public ResponseEntity<Object> creteOrder(CreateOrderRequest createOrderRequest){
        try {
            Orders orders = new Orders();
            orders.setOrderId(generateOrderId());
            orders.setPrice(createOrderRequest.getPrice());
            orders.setUserId(createOrderRequest.getUserId());
            ordersRepository.save(orders);
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiError("Error in creating order"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getOrderDetails(String orderId){
        try{
            Orders order = ordersRepository.findByOrderId(orderId);
            OrderDetails orderDetails = new OrderDetails(order.getOrderId(),
                    order.getUserId(), order.getPrice());
            return new ResponseEntity<Object>(orderDetails, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Object>(new ApiError("Error in fetching Order Details"), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> returnOrdersPlacedByGivenUser(String userId){
        try {

            List<OrderDetails> listOfOrders = new ArrayList<>();
            List<Orders> orderList = ordersRepository.findByUserId(userId);
            for(int i=0; i<orderList.size(); i++){
                OrderDetails orderDetails = new OrderDetails(orderList.get(i).getOrderId(),
                        orderList.get(i).getUserId(), orderList.get(i).getPrice());
                listOfOrders.add(orderDetails);
            }
            OrdersList ordersList = new OrdersList();
            ordersList.setListOfOrders(listOfOrders);
            ordersList.setCount(ordersList.getListOfOrders().size());
            return new ResponseEntity<Object>(ordersList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Object>(new ApiError("Error in getting orders"), HttpStatus.BAD_GATEWAY);
        }
    }

    public static String generateOrderId() {
        Random random = new Random();
        long randomNumber = random.nextInt(100000000 - 100000) + 100000;
        return "OD"+randomNumber;
    }
}
