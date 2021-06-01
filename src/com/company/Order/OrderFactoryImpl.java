package com.company.Order;

import com.company.Products.Product;
import com.company.Storage.Container;
import com.company.Storage.CourierCar;

import java.util.ArrayList;
import java.util.List;

public class OrderFactoryImpl implements OrderFactory {
    public static Container courierCar;
    private List<Observer> observers = new ArrayList<>();

    public OrderFactoryImpl() {
        courierCar = new CourierCar();
    }

    @Override
    public Order createOrder(String type, Product product) {
        Order order;
        if(type.equalsIgnoreCase("delivery")) {
            order = new Delivery(product);
            courierCar.addProduct(order);
            notifyAllObservers();
        }
        else throw new RuntimeException("This type of order doesn't exist!");

        return order;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
