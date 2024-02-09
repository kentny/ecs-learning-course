package org.example.product.controller;

import org.example.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.product.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    ResponseEntity<?> get(@PathVariable Long productId) {
        Optional<Product> product = this.productService.get(productId);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Id Not Found");
        }
        return ResponseEntity.ok(product.get());
    }
}
