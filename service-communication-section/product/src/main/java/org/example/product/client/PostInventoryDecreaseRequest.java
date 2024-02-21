package org.example.product.client;

public record PostInventoryDecreaseRequest(
        Long productId,
        Integer quantity
) {}
