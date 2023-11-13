package com.example.OrderService.service;

import com.example.OrderService.model.Orders_By_User;
import com.example.OrderService.records.OrderApiRequest;

import java.util.List;


public interface OrdersService {
    Orders_By_User createOrder(OrderApiRequest order);

    List<Orders_By_User> getOrdersByUser(long id);
}
