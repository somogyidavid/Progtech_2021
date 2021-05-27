package com.company.Products;

import com.company.Products.Accessories.AccessoriesProductFactory;
import com.company.Products.Clothes.ClothesProductFactory;
import com.company.Products.IT.ITProductFactory;

public class AbstractFactory {
    public static ProductFactory getProductFactory(String name) {
        ProductFactory productFactory;
        if(name.equalsIgnoreCase("accessories")) {
            productFactory = AccessoriesProductFactory.getInstance();
        }
        else if (name.equalsIgnoreCase("clothes")) {
            productFactory = ClothesProductFactory.getInstance();
        }
        else if (name.equalsIgnoreCase("IT")) {
            productFactory = ITProductFactory.getInstance();
        }
        else throw new RuntimeException("Not existing type of factory!");

        return productFactory;
    }
}
