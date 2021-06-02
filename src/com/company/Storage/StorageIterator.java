package com.company.Storage;

import com.company.Products.Product;

import java.util.List;

public class StorageIterator implements Iterator {
    List<Product> products;
    int position = 0;

    public StorageIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return position < (long) products.size() && products.get(position) != null;
    }

    @Override
    public Object next() {
        Product product = products.get(position);
        position++;
        return product;
    }
}
