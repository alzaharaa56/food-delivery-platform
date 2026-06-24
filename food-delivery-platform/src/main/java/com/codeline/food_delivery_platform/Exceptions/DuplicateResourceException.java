package com.codeline.food_delivery_platform.Exceptions;


public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException(String message) {
        super(message);
    }
}
