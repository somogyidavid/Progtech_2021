package com.company.Warehouse;

import com.company.Products.Product;

public interface Container {
    void addProduct(Product product);
    Iterator createIterator();
}
