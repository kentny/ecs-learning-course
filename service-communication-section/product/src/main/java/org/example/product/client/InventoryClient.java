package org.example.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-client", url = "${inventory.client.url}")
public interface InventoryClient {
    @GetMapping("/{productId}")
    GetInventoryDecreaseResponse get(@PathVariable Long productId);
}
