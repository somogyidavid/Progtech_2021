package com.company.Exceptions;

public class ProductNotExistException extends Exception {
    public ProductNotExistException() { }
    public ProductNotExistException(String message) {
        super(message);
    }
}
