package org.example.order.service;

import org.example.order.model.Order;

import java.util.Optional;

public interface OrderService {
    Optional<Order> createOrder(Long productId, Integer quantity);
}
