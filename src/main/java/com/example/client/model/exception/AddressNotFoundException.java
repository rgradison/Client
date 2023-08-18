package com.example.client.model.exception;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(Long id) {
        super("Could not find physical address with id: {0}" + id);
    }
}
