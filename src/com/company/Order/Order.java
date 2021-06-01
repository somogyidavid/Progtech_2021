package com.company.Order;

import com.company.Packing.PolystyrenePieces;
import com.company.Products.Product;

public abstract class Order implements Product {
    Product product;

    public Order(Product product) {
        this.product = product;
    }

    public Product packProduct() {
        box();
        fillBox();
        addressing();
        return product;
    }

    abstract void box();
    abstract void addressing();
    abstract void fillBox();
}
