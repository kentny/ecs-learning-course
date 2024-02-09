package org.example.inventory.controller;

import org.example.inventory.model.Inventory;
import org.example.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {
    final private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{productId}")
    ResponseEntity<?> get(@PathVariable Long productId) {
        Optional<Inventory> inventory = this.inventoryService.get(productId);
        return this.respondWithInventoryOrNotFound(inventory);
    }

    @PostMapping("/decrease")
    ResponseEntity<?> postDecrease(@RequestBody PostInventoryDecreaseRequest request) {
        Optional<Inventory> inventory = this.inventoryService.decrease(request.productId(), request.quantity());
        return this.respondWithInventoryOrNotFound(inventory);
    }

    private ResponseEntity<?> respondWithInventoryOrNotFound(Optional<Inventory> inventory) {
        if (inventory.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Id Not Found");
        }
        return ResponseEntity.ok(inventory.get());
    }
}
