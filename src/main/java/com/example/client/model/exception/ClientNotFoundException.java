package com.example.client.model.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Could not client with id: {0}" + id);
    }
}
