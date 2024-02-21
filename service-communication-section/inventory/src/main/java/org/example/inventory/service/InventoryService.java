package org.example.inventory.service;

import org.example.inventory.model.Inventory;

import java.util.Optional;

public interface InventoryService {
    Optional<Inventory> get(Long productId);
    Optional<Inventory> decrease(Long productId, Integer quantity);
}
