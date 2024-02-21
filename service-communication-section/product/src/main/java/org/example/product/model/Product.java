package org.example.product.model;

public record Product(
        Long productId,
        String name,
        Integer inventoryQuantity
) {
    public Product withInventoryQuantity(Integer quantity) {
        return new Product(this.productId, this.name, quantity);
    }
}
