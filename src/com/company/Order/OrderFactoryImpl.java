package com.company.Order;

import com.company.Exceptions.ContainerFullException;
import com.company.Exceptions.NotExistingTypeOfOrderException;
import com.company.Exceptions.WarehouseIsEmptyException;
import com.company.Management.Observer;
import com.company.Products.Product;
import com.company.Storage.Container;
import com.company.Storage.CourierCar;
import com.company.Storage.Iterator;

import java.util.ArrayList;
import java.util.List;

public class OrderFactoryImpl implements OrderFactory {
    public static List<CourierCar> courierCars = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private int ID = 0;
    Container warehouse;

    public OrderFactoryImpl(Container warehouse) {
        courierCars.add(new CourierCar());
        this.warehouse = warehouse;
        ID++;
    }

    @Override
    public Order createOrder(String type, Product product) throws ContainerFullException, NotExistingTypeOfOrderException, WarehouseIsEmptyException {
        if(warehouse.getNumberOfItems() == 0){
            throw new WarehouseIsEmptyException("Cannot create order if the warehouse is empty!");
        }

        Order order;
        if(type.equalsIgnoreCase("delivery")) {
            order = new Delivery(product);
            courierCars.get(ID - 1).addProduct(order);
            warehouse.removeProduct(product);
            notifyAllObservers();
        }
        else throw new NotExistingTypeOfOrderException("This type of order doesn't exist!");

        return order;
    }

    public static int getNumberOfOrders() {
        int sum = 0;
        Iterator iterator;;
        for (CourierCar courierCar : courierCars) {
            iterator = courierCar.createIterator();
            while (iterator.hasNext()) {
                iterator.next();
                sum++;
            }
        }
        return sum;
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
