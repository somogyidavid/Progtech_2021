package com.company;

import com.company.Products.AbstractFactory;
import com.company.Products.Product;
import com.company.Products.ProductFactory;
import com.company.Warehouse.Container;
import com.company.Warehouse.Iterator;
import com.company.Warehouse.Warehouse;
import com.company.Warehouse.WarehouseIterator;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private Container warehouse;

    public void test(){
        warehouse = new Warehouse();
        ProductFactory productFactory = AbstractFactory.getProductFactory("IT");

        for (int i = 0; i < 10 ; i++) {
            if (i % 2 == 0){
                warehouse.addProduct(productFactory.createProduct("laptop", 1000));
            }
            if (i % 2 == 1){
                warehouse.addProduct(productFactory.createProduct("processor", 50));
            }
        }

        getProducts();
    }

    public void getProducts() {
        Iterator warehouseIterator = warehouse.createIterator();
        System.out.println("-----PRODUCTS-----");
        getProducts(warehouseIterator);
    }

    private void getProducts(Iterator iterator) {
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.getClass().getSimpleName() + " " + product.getPrice());
        }
    }
}
