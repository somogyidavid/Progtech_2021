package com.company.Exceptions;

public class NotExistingFactoryTypeException extends Exception {
    public NotExistingFactoryTypeException() { }
    public NotExistingFactoryTypeException(String message){
        super(message);
    }
}
