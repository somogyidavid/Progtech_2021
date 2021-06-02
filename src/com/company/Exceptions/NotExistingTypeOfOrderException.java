package com.company.Exceptions;

public class NotExistingTypeOfOrderException extends Exception {
    public NotExistingTypeOfOrderException() { }
    public NotExistingTypeOfOrderException(String message) {
        super(message);
    }
}
