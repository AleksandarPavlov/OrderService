package com.example.OrderService.records;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("product")
public record Product(String product_id, String name, String description, String category, String brandId, long price) {
}
