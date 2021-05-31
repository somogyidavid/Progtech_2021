package com.company.Products.Accessories;

import com.company.Products.Product;

public class Necklace implements Product {
    private int price;
    public Necklace(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Necklace";
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
