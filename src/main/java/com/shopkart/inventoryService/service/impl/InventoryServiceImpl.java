package com.shopkart.inventoryService.service.impl;

import com.shopkart.inventoryService.dto.InventoryDto;
import com.shopkart.inventoryService.entity.Inventory;
import com.shopkart.inventoryService.repository.InventoryRepository;
import com.shopkart.inventoryService.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventory() {
        Iterable<Inventory> inventoryItems = inventoryRepository.findAll();
        List<Inventory> inventoryList = new ArrayList<>();
        inventoryItems.forEach(inventoryList::add);
        return inventoryList;
    }

    @Override
    public List<Inventory> getInventoryByProductId(String productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @Override
    public List<Inventory> getInventoryByMerchantId(String merchantId) {
        return inventoryRepository.findByMerchantId(merchantId);
    }

    @Override
    public Boolean addOrUpdateInventory(Inventory inventory) {

        inventoryRepository.save(inventory);
        if(inventory == null){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }
}
