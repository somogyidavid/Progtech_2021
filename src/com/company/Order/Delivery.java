package com.company.Order;

import com.company.Packing.AddressSticker;
import com.company.Packing.CardBoardBox;
import com.company.Products.Product;

public class Delivery extends Order {
    public Delivery(Product product){
        super(product);
        packProduct();
    }

    @Override
    void box() {
        product = new CardBoardBox(product);
    }

    @Override
    void addressing() {
        product = new AddressSticker(product);
    }

    @Override
    public int getPrice() {
        return product.getPrice();
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }
}
