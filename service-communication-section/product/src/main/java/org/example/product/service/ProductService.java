package org.example.product.service;

import org.example.product.client.GetInventoryDecreaseResponse;
import org.example.product.client.InventoryClient;
import feign.FeignException;
import org.example.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    final private InventoryClient inventoryClient;

    public ProductService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    final private ArrayList<Product> products = new ArrayList<>(
            List.of(
                new Product(1L, "みかん", 0),
                new Product(2L, "りんご", 0),
                new Product(3L, "パイナップル", 0)
            )
    );

    public Optional<Product> get(Long productId) {
        try {
            // Get Inventory
            GetInventoryDecreaseResponse response = this.inventoryClient.get(productId);

            Optional<Product> product = this.products.stream()
                    .filter(p -> Objects.equals(p.productId(), productId))
                    .findFirst();

            if (product.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(product.get().withInventoryQuantity(response.quantity()));
        } catch (FeignException.NotFound e) {
            System.out.println("Resource not found: " + e.getMessage());
            return Optional.empty();
        }
    }
}
