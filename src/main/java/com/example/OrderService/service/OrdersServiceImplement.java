package com.example.OrderService.service;

import com.example.OrderService.exceptions.CustomException;
import com.example.OrderService.model.Orders_By_User;
import com.example.OrderService.records.OrderApiRequest;
import com.example.OrderService.repository.OrdersByUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class OrdersServiceImplement implements OrdersService {

    private final OrdersByUserRepository ordersByUserRepository;

    public OrdersServiceImplement(OrdersByUserRepository ordersByUserRepository) {
        this.ordersByUserRepository = ordersByUserRepository;
    }

    @Override
    public Orders_By_User createOrder(OrderApiRequest order) {
        if(order.products().isEmpty()){
            throw new CustomException("Products list cannot be empty.", HttpStatus.BAD_REQUEST);
        }
        Orders_By_User newOrder = new Orders_By_User();
        newOrder.setOrder_id(UUID.randomUUID());
        newOrder.setProducts(order.products());
        newOrder.setTimestamp(LocalDateTime.now());
        newOrder.setUser_id(order.userId());
        ordersByUserRepository.save(newOrder);

        return newOrder;
    }

    @Override
    public List<Orders_By_User> getOrdersByUser(long id) {
        return ordersByUserRepository.findByUserId(id);
    }
}
