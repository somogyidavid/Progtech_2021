package com.company.Storage;

import com.company.Products.Product;

public interface Container {
    void addProduct(Product product);
    Iterator createIterator();
}
