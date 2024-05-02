package com.ranga.minilibrary.inventory.exceptions;

public class BookIsNotIssuedException extends RuntimeException {
    public BookIsNotIssuedException() {
        super("Book is Not Issued");
    }

    public BookIsNotIssuedException(String message) {
        super(message);
    }
}
