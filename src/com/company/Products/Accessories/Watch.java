package com.company.Products.Accessories;

import com.company.Products.Product;

public class Watch implements Product {
    private int price;
    public Watch(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Watch";
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
