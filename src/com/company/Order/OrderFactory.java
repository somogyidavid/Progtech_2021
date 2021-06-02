package com.company.Order;

import com.company.Exceptions.ContainerFullException;
import com.company.Exceptions.NotExistingTypeOfOrderException;
import com.company.Products.Product;

public interface OrderFactory {
    Order createOrder(String type, Product product) throws ContainerFullException, NotExistingTypeOfOrderException;
    void attach(Observer observer);
    void notifyAllObservers();
}
