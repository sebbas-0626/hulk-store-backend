package com.example.hulk_store_backend.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Category not found with ID: " + id);
    }
}
