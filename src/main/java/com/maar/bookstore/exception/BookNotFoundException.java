package com.maar.bookstore.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String id) {
        super("Book not found with id: " + id);
    }
}
