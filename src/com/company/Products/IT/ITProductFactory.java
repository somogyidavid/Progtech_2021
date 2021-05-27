package com.company.Products.IT;

import com.company.Products.IT.Processor;
import com.company.Products.IT.Laptop;
import com.company.Products.Product;
import com.company.Products.ProductFactory;

public class ITProductFactory implements ProductFactory {
    private ITProductFactory() {}
    private static ITProductFactory instance;

    public static ITProductFactory getInstance() {
        if (instance == null) {
            instance = new ITProductFactory();
        }
        return instance;
    }

    @Override
    public Product createProduct(String name, int price) {
        Product product;
        if(name.equalsIgnoreCase("Laptop")) {
            product = new Laptop(price);
        }
        else if(name.equalsIgnoreCase("Processor")) {
            product = new Processor(price);
        }
        else throw new RuntimeException("This product doesn't exist!");

        return product;
    }
}
