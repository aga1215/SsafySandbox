package com.ssafy.sandbox.config.exception.dtoException;

public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(String modelName, Long id) {
        super("Model " + modelName + " not found with given id " + id);
    }
}