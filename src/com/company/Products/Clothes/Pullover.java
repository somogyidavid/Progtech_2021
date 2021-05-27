package com.company.Products.Clothes;

import com.company.Products.Product;

public class Pullover implements Product {
    private int price;
    public Pullover(int price){
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
