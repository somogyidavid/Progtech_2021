package com.company.Storage;

import com.company.Products.Product;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Container {
    private int maxItems = 10;
    private int numberOfItems = 0;
    private List<Product> products = new ArrayList<>();
    private static Warehouse instance;

    public static Warehouse getInstance() {
        if(instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    @Override
    public void addProduct(Product product) {
        if(numberOfItems >= maxItems) {
            throw new RuntimeException("The warehouse is full!");
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