package com.company.Storage;

import com.company.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class CourierCar implements Container {

    private int maxItems = 10;
    private int numberOfItems = 0;
    private List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        if(numberOfItems >= maxItems) {
            throw new RuntimeException("This courier car is full!");
        }
        else {
            products.add(product);
            numberOfItems++;
        }
    }

    @Override
    public Iterator createIterator() {
        return new StorageIterator(products);
    }
}
