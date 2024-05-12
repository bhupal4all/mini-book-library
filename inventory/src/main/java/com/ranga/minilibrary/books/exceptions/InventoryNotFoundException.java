package com.ranga.minilibrary.books.exceptions;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String message) {
        super(message);
    }

    public InventoryNotFoundException(){
        super("Inventory not found");
    }
}
