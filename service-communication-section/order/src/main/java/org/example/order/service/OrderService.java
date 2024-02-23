package org.example.order.service;

import feign.FeignException;
import org.example.order.client.InventoryClient;
import org.example.order.client.PostInventoryDecreaseRequest;
import org.example.order.model.Order;
import org.example.order.model.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {
    final private InventoryClient inventoryClient;
    final private ArrayList<Order> orders = new ArrayList<>();

    public OrderService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public Optional<Order> createOrder(Long productId, Integer quantity) {
        try {
            PostInventoryDecreaseRequest request = new PostInventoryDecreaseRequest(productId, quantity);
            this.inventoryClient.postDecrease(request);
            Long orderId = (long) (this.orders.size() + 1);
            Order order = new Order(
                    orderId,
                    productId,
                    quantity,
                    OrderStatus.completed
            );
            this.orders.add(order);
            return Optional.of(order);

        } catch (FeignException.NotFound e) {
            System.out.println("Resource not found: " + e.getMessage());
            return Optional.empty();
        }
    }
}
