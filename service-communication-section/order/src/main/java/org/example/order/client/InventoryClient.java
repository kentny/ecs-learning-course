package org.example.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-client", url = "${inventory.client.url}")
public interface InventoryClient {
    @PostMapping("/decrease")
    PostInventoryDecreaseResponse postDecrease(@RequestBody PostInventoryDecreaseRequest request);
}
