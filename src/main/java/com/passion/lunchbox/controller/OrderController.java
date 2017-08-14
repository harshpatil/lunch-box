package com.passion.lunchbox.controller;

import com.passion.lunchbox.dto.Orders;
import com.passion.lunchbox.model.OrdersList;
import com.passion.lunchbox.repository.OrdersRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/order")
public class OrderController {

    @Autowired
    private OrdersRepository ordersRepository;

    @ApiOperation(value = "Place an Order", notes = "place an order")
    @PostMapping()
    public @ResponseBody Orders addOrder(@RequestBody Orders orders){
        ordersRepository.save(orders);
        return orders;
    }

    @ApiOperation(value = "Get order details", notes = "get order details")
    @GetMapping()
    public @ResponseBody Orders getOrder(@RequestParam String orderId){
        return ordersRepository.findByOrderId(orderId);
    }

    @ApiOperation(value = "Get User detaisl", notes = "return uder details")
    @GetMapping("/{userId}")
    public @ResponseBody OrdersList getOrdersPlacedByUser(@PathVariable(value="userId") String userId){
        OrdersList ordersList = new OrdersList();
        ordersList.setListOfOrders(ordersRepository.findByUserId(userId));
        ordersList.setCount(ordersList.getListOfOrders().size());
        return ordersList;
    }
}
