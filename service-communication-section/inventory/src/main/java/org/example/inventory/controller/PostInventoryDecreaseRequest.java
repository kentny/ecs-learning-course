package org.example.inventory.controller;

public record PostInventoryDecreaseRequest(
        Long productId,
        Integer quantity
) {}
