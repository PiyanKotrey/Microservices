package co.draxler.inventory_service.service;

import co.draxler.inventory_service.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
