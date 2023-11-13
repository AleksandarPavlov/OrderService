package com.example.OrderService.repository;


import com.example.OrderService.model.Orders_By_User;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

@Table("orders_by_user")
public interface OrdersByUserRepository extends CassandraRepository<Orders_By_User, UUID> {
    @Query("SELECT * FROM orders_by_user WHERE user_id = ?0")
    List<Orders_By_User> findByUserId(long user_id);
}
