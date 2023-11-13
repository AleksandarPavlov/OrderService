package com.example.OrderService.records;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderApiRequest(@NotNull(message = "User cannot be null")  Long userId, List<Product> products) {
}
