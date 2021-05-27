package com.company.Products.Clothes;

import com.company.Products.Product;

public class Jeans implements Product {
    private int price;
    public Jeans(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
