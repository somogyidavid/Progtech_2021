package com.company.Order;

import com.company.Packing.AddressSticker;
import com.company.Packing.CardBoardBox;
import com.company.Packing.PolystyrenePieces;
import com.company.Products.Product;

public class Delivery extends Order {
    public Delivery(Product product){
        super(product);
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
    void fillBox() {
        product = new PolystyrenePieces(product);
    }

    @Override
    public int getPrice() {
        return product.getPrice() + 1000;
    }

    @Override
    public String getDescription() {
        return product.getDescription();
    }
}
