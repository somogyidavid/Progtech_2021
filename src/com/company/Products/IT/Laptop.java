package com.company.Products.IT;

import com.company.Products.Product;

public class Laptop implements Product {
    private int price;
    public Laptop(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Laptop";
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
