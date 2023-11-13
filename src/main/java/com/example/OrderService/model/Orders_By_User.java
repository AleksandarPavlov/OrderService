package com.example.OrderService.model;

import com.example.OrderService.records.Product;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public  class Orders_By_User {
    @PrimaryKey
    private UUID order_id;
    private long user_id;
    private List<Product> products;
    private LocalDateTime timestamp;

    public UUID getOrder_id() {
        return order_id;
    }

    public void setOrder_id(UUID order_id) {
        this.order_id = order_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
