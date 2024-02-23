package org.example.inventory.service;

import org.example.inventory.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    private ArrayList<Inventory> inventories = new ArrayList<>(
            Arrays.asList(
                    new Inventory(1L, 100),
                    new Inventory(2L, 200),
                    new Inventory(3L, 300)
            )
    );

    public Optional<Inventory> get(Long productId) {
        return this.inventories.stream()
                .filter(inventory -> Objects.equals(productId, inventory.productId()))
                .findFirst();
    }

    public Optional<Inventory> decrease(Long productId, Integer quantity) {
        this.inventories = this.inventories.stream().map(inventory -> {
            if (Objects.equals(productId, inventory.productId())) {
                Integer newQuantity = (inventory.quantity() > quantity) ? inventory.quantity() - quantity : 0;
                return new Inventory(productId, newQuantity);
            }
            return inventory;
        }).collect(Collectors.toCollection(ArrayList::new));

        return this.inventories.stream()
                .filter(inventory -> Objects.equals(productId, inventory.productId()))
                .findFirst();
    }
}
