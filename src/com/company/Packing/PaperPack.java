package com.company.Packing;

import com.company.Products.Product;

public class PaperPack implements PackingDecorator {
    Product product;

    public PaperPack(Product product) {
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice() + 50;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + ", in a paper packaging";
    }
}
