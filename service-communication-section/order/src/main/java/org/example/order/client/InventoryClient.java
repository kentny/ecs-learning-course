package org.example.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-client", url = "http://inventory:8080/api/inventories")
public interface InventoryClient {
    @PostMapping("/decrease")
    PostInventoryDecreaseResponse postDecrease(@RequestBody PostInventoryDecreaseRequest request);
}
