package com.shopkart.inventoryService.repository;

import com.shopkart.inventoryService.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,String> {

    List<Inventory> findByProductId(String productId);
    List<Inventory> findByMerchantId(String productId);


}
