package com.example.hulk_store_backend.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("not found with ID: " + id);
    }

    public ResourceNotFoundException(String s) {
    }
}
