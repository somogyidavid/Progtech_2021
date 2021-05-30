package com.company.Warehouse;

import com.company.Products.Product;

import java.util.List;

public class WarehouseIterator implements Iterator {
    List<Product> products;
    int position = 0;

    public WarehouseIterator(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return position < products.stream().count() && products.get(position) != null;
    }

    @Override
    public Object next() {
        Product product = products.get(position);
        position++;
        return product;
    }
}
