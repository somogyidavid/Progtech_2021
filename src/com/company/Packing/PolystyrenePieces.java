package com.company.Packing;

import com.company.Products.Product;

public class PolystyrenePieces implements PackingDecorator {
    Product product;

    public PolystyrenePieces(Product product) {
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice() + 50;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + ", filled with polystyrene pieces";
    }
}
