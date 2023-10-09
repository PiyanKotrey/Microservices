package co.draxler.inventory_service.controller;

import co.draxler.inventory_service.dto.InventoryResponse;
import co.draxler.inventory_service.model.Inventory;
import co.draxler.inventory_service.reository.InventoryRepository;
import co.draxler.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
@Slf4j
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
        log.info("Received inventory check request for skuCode: {}", skuCode);
        return inventoryService.isInStock(skuCode);
    }


}
