package com.shopkart.inventoryService.service;

import com.shopkart.inventoryService.dto.InventoryDto;
import com.shopkart.inventoryService.entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllInventory();
    List<Inventory> getInventoryByProductId(String productId);
    List<Inventory> getInventoryByMerchantId(String merchantId);
    Boolean addOrUpdateInventory(Inventory inventory);
}
