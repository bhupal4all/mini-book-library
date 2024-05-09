package com.ranga.minilibrary.inventory.exceptions;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException(String message) {
        super(message);
    }

    public InsufficientInventoryException(){
        super("Insufficient inventory");
    }
}
