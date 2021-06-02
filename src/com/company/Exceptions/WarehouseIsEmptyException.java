package com.company.Exceptions;

public class WarehouseIsEmptyException extends Exception {
    public WarehouseIsEmptyException() { }
    public WarehouseIsEmptyException(String message) {
        super(message);
    }
}
