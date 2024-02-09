package org.example.order.controller;

import org.example.order.model.Order;
import org.example.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    ResponseEntity<?> post(@RequestBody PostOrderRequest request) {
        Optional<Order> order = this.orderService.createOrder(request.productId(), request.quantity());

        if (order.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Id Not Found");
        }
        return ResponseEntity.ok(order.get());
    }
}

