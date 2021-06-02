package com.company.Order;

import com.company.Exceptions.ContainerFullException;
import com.company.Exceptions.NotExistingTypeOfOrderException;
import com.company.Exceptions.WarehouseIsEmptyException;
import com.company.Management.Observer;
import com.company.Products.Product;

public interface OrderFactory {
    Order createOrder(String type, Product product) throws ContainerFullException, NotExistingTypeOfOrderException, WarehouseIsEmptyException;
    void attach(Observer observer);
    void notifyAllObservers();
}
