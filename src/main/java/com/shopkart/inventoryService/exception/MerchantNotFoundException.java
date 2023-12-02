package com.shopkart.inventoryService.exception;


public class MerchantNotFoundException extends RuntimeException {

    public MerchantNotFoundException(String merchantId) {
        super("Merchant not found with ID: " + merchantId);
    }
}
