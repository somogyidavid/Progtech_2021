package com.company;

import com.company.Packing.AddressSticker;
import com.company.Packing.CardBoardBox;
import com.company.Packing.PolystyrenePieces;
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
    private Container courierCar;

    public void test(){
        warehouse = new Warehouse();
        courierCar = new Warehouse();
        ProductFactory productFactory = AbstractFactory.getProductFactory("IT");

        for (int i = 0; i < 10 ; i++) {
            if (i % 2 == 0){
                warehouse.addProduct(productFactory.createProduct("laptop", 150000));
            }
            if (i % 2 == 1){
                warehouse.addProduct(productFactory.createProduct("processor", 80000));
            }
        }

        getProducts();
        packProducts();
        getPackedProducts();
    }

    public void getProducts() {
        Iterator warehouseIterator = warehouse.createIterator();
        System.out.println("-----PRODUCTS-----");
        getProducts(warehouseIterator);
    }

    private void getProducts(Iterator iterator) {
        while (iterator.hasNext()) {
            Product product = (Product) iterator.next();
            System.out.println(product.getDescription() + " - " + product.getPrice() + "HUF");
        }
    }

    public void packProducts() {
        Iterator warehouseIterator = warehouse.createIterator();
        while(warehouseIterator.hasNext()) {
            Product product = (Product) warehouseIterator.next();
            courierCar.addProduct(new AddressSticker(new PolystyrenePieces(new CardBoardBox(product))));
            System.out.println(product);
        }
    }
    public void getPackedProducts() {
        Iterator courierCarIterator = courierCar.createIterator();
        System.out.println("-----PACKED PRODUCTS-----");
        getProducts(courierCarIterator);
    }
}
