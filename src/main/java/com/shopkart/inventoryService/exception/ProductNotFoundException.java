package com.shopkart.inventoryService.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String productId) {
        super("Product not found with ID: " + productId);
    }
}