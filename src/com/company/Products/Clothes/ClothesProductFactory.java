package com.company.Products.Clothes;

import com.company.Exceptions.ProductNotExistException;
import com.company.Products.Product;
import com.company.Products.ProductFactory;

public class ClothesProductFactory implements ProductFactory {
    private ClothesProductFactory() {}
    private static ClothesProductFactory instance;

    public static ClothesProductFactory getInstance() {
        if (instance == null) {
            instance = new ClothesProductFactory();
        }
        return instance;
    }

    @Override
    public Product createProduct(String name, int price) throws ProductNotExistException {
        Product product;
        if(name.equalsIgnoreCase("jeans")) {
            product = new Jeans(price);
        }
        else if(name.equalsIgnoreCase("pullover")) {
            product = new Pullover(price);
        }
        else throw new ProductNotExistException("This product doesn't exist!");

        return product;
    }
}
