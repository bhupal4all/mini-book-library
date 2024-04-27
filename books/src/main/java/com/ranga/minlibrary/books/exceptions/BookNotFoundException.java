package com.ranga.minlibrary.books.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book Not Found");
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
