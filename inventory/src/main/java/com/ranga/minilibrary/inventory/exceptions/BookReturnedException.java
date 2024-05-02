package com.ranga.minilibrary.inventory.exceptions;

public class BookReturnedException extends RuntimeException {
    public BookReturnedException() {
        super("Book is already returned");
    }

    public BookReturnedException(String message) {
        super(message);
    }
}
