package com.projet.library.domain;

public class BookNotFound extends RuntimeException {

    @Override
    public String getMessage() {

        return "Book not found";
    }
}
