package com.company.Order;

import com.company.Exceptions.ContainerFullException;
import com.company.Products.Product;

public interface OrderFactory {
    Order createOrder(String type, Product product) throws ContainerFullException;
    void attach(Observer observer);
    void notifyAllObservers();
}
