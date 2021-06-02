package com.company.Exceptions;

public class ContainerFullException extends Exception{
    public ContainerFullException() { }
    public ContainerFullException(String message) {
        super(message);
    }
}
