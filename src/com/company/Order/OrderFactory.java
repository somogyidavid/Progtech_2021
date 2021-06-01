package com.company.Order;

import com.company.Products.Product;

public interface OrderFactory {
    Order createOrder(String type, Product product);
    void attach(Observer observer);
    void notifyAllObservers();
}
