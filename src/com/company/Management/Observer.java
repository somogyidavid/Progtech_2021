package com.company.Management;

import com.company.Order.Order;

public abstract class Observer {
    protected Order order;
    public abstract void update();
}
