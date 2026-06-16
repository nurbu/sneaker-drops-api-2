package com.pluralsight.sneakerdropsapi.service;

public class NotFoundException extends RuntimeException {

    public NotFoundException(long id) {
        super("No sneaker found with id " + id);
    }
}
