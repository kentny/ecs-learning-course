package org.example.order.client;

public record PostInventoryDecreaseResponse(
        Long productId,
        Integer quantity
) {}
