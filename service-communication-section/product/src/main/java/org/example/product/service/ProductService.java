package org.example.product.service;

import org.example.product.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> get(Long productId);
}
