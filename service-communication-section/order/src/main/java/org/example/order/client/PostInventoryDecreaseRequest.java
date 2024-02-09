package org.example.order.client;

public record PostInventoryDecreaseRequest(
        Long productId,
        Integer quantity
) {}
