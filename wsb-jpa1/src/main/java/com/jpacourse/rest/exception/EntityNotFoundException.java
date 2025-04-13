package com.jpacourse.rest.exception;

public class EntityNotFoundException extends RuntimeException {

    // Konstruktor przyjmujący ID — do automatycznych komunikatów
    public EntityNotFoundException(Long id) {
        super("Could not find entity of id " + id);
    }

    // Konstruktor przyjmujący własny komunikat — do customowych wiadomości
    public EntityNotFoundException(String message) {
        super(message);
    }
}
