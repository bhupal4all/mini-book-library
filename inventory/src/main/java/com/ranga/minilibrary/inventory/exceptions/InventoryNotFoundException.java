package com.ranga.minilibrary.inventory.exceptions;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String message) {
        super(message);
    }

    public InventoryNotFoundException(){
        super("Inventory not found");
    }
}
