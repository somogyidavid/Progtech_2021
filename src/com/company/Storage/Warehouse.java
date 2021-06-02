package com.company.Storage;

import com.company.Exceptions.ContainerFullException;
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
    public void addProduct(Product product) throws ContainerFullException {
        if(numberOfItems >= maxItems) {
            throw new ContainerFullException("The warehouse is full!");
        }
        else {
            products.add(product);
            numberOfItems++;
        }
    }

    @Override
    public void removeProduct(Product product) {
        this.products.remove(product);
        this.numberOfItems--;
    }

    @Override
    public void clearContainer(){
        this.products = new ArrayList<>();
        this.numberOfItems = 0;
    }

    @Override
    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    @Override
    public Iterator createIterator() {
        return new StorageIterator(products);
    }
}
