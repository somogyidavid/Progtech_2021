package com.company.Products.Accessories;

import com.company.Exceptions.ProductNotExistException;
import com.company.Products.Product;
import com.company.Products.ProductFactory;

public class AccessoriesProductFactory implements ProductFactory {
    private AccessoriesProductFactory() {}
    private static AccessoriesProductFactory instance;

    public static AccessoriesProductFactory getInstance() {
        if (instance == null) {
            instance = new AccessoriesProductFactory();
        }
        return instance;
    }

    @Override
    public Product createProduct(String name, int price) throws ProductNotExistException {
        Product product;
        if(name.equalsIgnoreCase("necklace")) {
            product = new Necklace(price);
        }
        else if(name.equalsIgnoreCase("watch")) {
            product = new Watch(price);
        }
        else throw new ProductNotExistException("This product doesn't exist!");

        return product;
    }
}
