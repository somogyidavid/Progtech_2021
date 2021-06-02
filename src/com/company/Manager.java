package com.company;

import com.company.Order.Observer;
import com.company.Order.OrderFactory;

public class Manager extends Observer {
    private int soldProducts = 0;
    OrderFactory factory;

    public Manager(OrderFactory factory) {
        this.factory = factory;
        this.factory.attach(this);
    }

    @Override
    public void update() {
        System.out.println("A product has been sold!");
        soldProducts++;
    }

    public int getSoldProducts() {
        return this.soldProducts;
    }
}
