package com.EnterpriseResourcePlanning.InventoryManagement.Exception;


public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String message) {
        super(message);  // Pass the custom message to the parent class (RuntimeException)
    }
}

