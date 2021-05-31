package com.company.Products.IT;

import com.company.Products.Product;

public class Processor implements Product {
    private int price;
    public Processor(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Processor";
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
