package com.company.Storage;

import com.company.Exceptions.ContainerFullException;
import com.company.Products.Product;

public interface Container {
    void addProduct(Product product) throws ContainerFullException;
    int getNumberOfItems();
    Iterator createIterator();
}
