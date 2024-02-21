package org.example.product.client;

public record GetInventoryDecreaseResponse(
        Long productId,
        Integer quantity
) {}
