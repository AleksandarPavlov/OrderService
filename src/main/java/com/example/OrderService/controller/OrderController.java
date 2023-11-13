package com.example.OrderService.controller;

import com.example.OrderService.model.Orders_By_User;
import com.example.OrderService.records.OrderApiRequest;
import com.example.OrderService.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrdersService ordersService;

    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<Orders_By_User> createOrder(@RequestBody OrderApiRequest order) throws IOException {
        return new ResponseEntity<>(ordersService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<Orders_By_User>> getOrderByUser(@PathVariable long id){
        return new ResponseEntity<>(ordersService.getOrdersByUser(id), HttpStatus.OK);
    }



}
