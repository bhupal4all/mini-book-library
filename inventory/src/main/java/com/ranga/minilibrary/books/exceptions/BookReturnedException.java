package com.ranga.minilibrary.books.exceptions;

public class BookReturnedException extends RuntimeException {
    public BookReturnedException() {
        super("Book is already returned");
    }

    public BookReturnedException(String message) {
        super(message);
    }
}
