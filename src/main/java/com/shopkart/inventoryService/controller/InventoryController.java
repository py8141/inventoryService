package com.shopkart.inventoryService.controller;


import com.shopkart.inventoryService.dto.InventoryDto;
import com.shopkart.inventoryService.entity.Inventory;
import com.shopkart.inventoryService.exception.MerchantNotFoundException;
import com.shopkart.inventoryService.exception.ProductNotFoundException;
import com.shopkart.inventoryService.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

//    @GetMapping
//    public ResponseEntity<List<InventoryDto>> getAllInventory(){
//
//        List<Inventory> inventoryList = inventoryService.getAllInventory();
//        List<InventoryDto> inventoryDtos = new ArrayList<>();
//        for(Inventory inventory : inventoryList){
//            InventoryDto inventoryDto = new InventoryDto();
//            BeanUtils.copyProperties(inventory,inventoryDto);
//            inventoryDtos.add(inventoryDto);
//        }
//
//        return new ResponseEntity<>(inventoryDtos,HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Boolean> saveInInventory(@RequestBody InventoryDto inventoryDto){
//        Inventory inventory = new Inventory();
//        BeanUtils.copyProperties(inventoryDto,inventory);
//
//        return ResponseEntity.ok(inventoryService.addOrUpdateInventory(inventory));
//
//
//    }

    @GetMapping
    public ResponseEntity<List<InventoryDto>> getAllInventory() {
        try {
            List<Inventory> inventoryList = inventoryService.getAllInventory();
            List<InventoryDto> inventoryDtos = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                InventoryDto inventoryDto = new InventoryDto();
                BeanUtils.copyProperties(inventory, inventoryDto);
                inventoryDtos.add(inventoryDto);
            }
            return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Boolean> saveInInventory(@RequestBody InventoryDto inventoryDto) {
        try {
            Inventory inventory = new Inventory();
            BeanUtils.copyProperties(inventoryDto, inventory);
            return ResponseEntity.ok(inventoryService.addOrUpdateInventory(inventory));
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/saveMultiple")
    public ResponseEntity<Boolean> saveInventoryMultiple(@RequestBody List<InventoryDto> inventoryDtos){
        for (InventoryDto inventoryDto : inventoryDtos) {
            Inventory inventory = new Inventory();
            BeanUtils.copyProperties(inventoryDto, inventory);
            inventoryService.addOrUpdateInventory(inventory);
        }
        return ResponseEntity.ok(Boolean.TRUE);


    }
//    @GetMapping("/product/{productId}")
//    public ResponseEntity<List<InventoryDto>> getInventoryByProductId(@PathVariable String productId){
//
//        List<Inventory> inventoryList = inventoryService.getInventoryByProductId(productId);
//
//        List<InventoryDto> inventoryDtos = new ArrayList<>();
//        for(Inventory inventory : inventoryList){
//            InventoryDto inventoryDto = new InventoryDto();
//            BeanUtils.copyProperties(inventory,inventoryDto);
//            inventoryDtos.add(inventoryDto);
//        }
//
//        return new ResponseEntity<>(inventoryDtos,HttpStatus.OK);
//
//    }
//
//    @GetMapping("/merchant/{merchantId}")
//    public ResponseEntity<List<InventoryDto>> getInventoryByMerchantId(@PathVariable String merchantId) {
//
//        List<Inventory> inventoryList = inventoryService.getInventoryByMerchantId(merchantId);
//
//        List<InventoryDto> inventoryDtos = new ArrayList<>();
//        for(Inventory inventory : inventoryList){
//            InventoryDto inventoryDto = new InventoryDto();
//            BeanUtils.copyProperties(inventory,inventoryDto);
//            inventoryDtos.add(inventoryDto);
//        }
//
//        return new ResponseEntity<>(inventoryDtos,HttpStatus.OK);
//
//    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryDto>> getInventoryByProductId(@PathVariable String productId) {
        try {
            List<Inventory> inventoryList = inventoryService.getInventoryByProductId(productId);
            List<InventoryDto> inventoryDtos = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                InventoryDto inventoryDto = new InventoryDto();
                BeanUtils.copyProperties(inventory, inventoryDto);
                inventoryDtos.add(inventoryDto);
            }
            return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            // Log the exception or handle as needed
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/merchant/{merchantId}")
    public ResponseEntity<List<InventoryDto>> getInventoryByMerchantId(@PathVariable String merchantId) {
        try {
            List<Inventory> inventoryList = inventoryService.getInventoryByMerchantId(merchantId);
            List<InventoryDto> inventoryDtos = new ArrayList<>();
            for (Inventory inventory : inventoryList) {
                InventoryDto inventoryDto = new InventoryDto();
                BeanUtils.copyProperties(inventory, inventoryDto);
                inventoryDtos.add(inventoryDto);
            }
            return new ResponseEntity<>(inventoryDtos, HttpStatus.OK);
        } catch (MerchantNotFoundException e) {
            // Log the exception or handle as needed
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
