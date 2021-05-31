package com.company.Packing;

import com.company.Products.Product;

public class AddressSticker implements PackingDecorator {
    Product product;

    public AddressSticker(Product product) {
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice();
    }

    @Override
    public String getDescription() {
        return product.getDescription() + ", address labeled";
    }
}
