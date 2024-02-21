package org.example.order.model;


public record Order(
        Long orderId,
        Long productId,
        Integer quantity,
        OrderStatus status
) {}

