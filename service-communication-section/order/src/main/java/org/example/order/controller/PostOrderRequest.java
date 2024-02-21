package org.example.order.controller;

public record PostOrderRequest(
        Long productId,
        Integer quantity
) {}
