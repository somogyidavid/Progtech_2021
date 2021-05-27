package com.company;

import com.company.Products.AbstractFactory;
import com.company.Products.Product;
import com.company.Products.ProductFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<Product> storage = new ArrayList<>();
        ProductFactory productFactory = AbstractFactory.getProductFactory("IT");

        for (int i = 0; i < 10 ; i++) {
            if (i % 3 == 0){
                storage.add(productFactory.createProduct("laptop", 1000));
            }
            if (i % 3 == 1){
                storage.add(productFactory.createProduct("processor", 50));
            }
        }

        for(Product product : storage) {
            System.out.println(product.getClass().getSimpleName() + " " + product.getPrice());
        }
    }
}
