package com.passion.lunchbox.controller;

import com.passion.lunchbox.dto.Orders;
import com.passion.lunchbox.model.CreateOrderRequest;
import com.passion.lunchbox.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "Place an Order", notes = "place an order")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addOrder(@RequestBody CreateOrderRequest createOrderRequest){
        return orderService.creteOrder(createOrderRequest);
    }

    @ApiOperation(value = "Get order details", notes = "get order details")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getOrder(@RequestParam String orderId){
        return orderService.getOrderDetails(orderId);
    }

    @ApiOperation(value = "Get User detaisl", notes = "return order details")
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrdersPlacedByUser(@PathVariable(value="userId") String userId){
        return orderService.returnOrdersPlacedByGivenUser(userId);
    }
}
