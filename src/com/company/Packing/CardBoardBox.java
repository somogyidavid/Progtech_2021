package com.company.Packing;

import com.company.Products.Product;

public class CardBoardBox implements PackingDecorator{
    Product product;

    public CardBoardBox(Product product) {
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice() + 100;
    }

    @Override
    public String getDescription() {
        return product.getDescription() + ", in cardboard box.";
    }
}
