package com.company.Products;

import com.company.Exceptions.NotExistingFactoryTypeException;
import com.company.Products.Accessories.AccessoriesProductFactory;
import com.company.Products.Clothes.ClothesProductFactory;
import com.company.Products.IT.ITProductFactory;

public class AbstractFactory {
    public static ProductFactory getProductFactory(String name) throws NotExistingFactoryTypeException {
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
        else throw new NotExistingFactoryTypeException("Not existing type of factory!");

        return productFactory;
    }
}
