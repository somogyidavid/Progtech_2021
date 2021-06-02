package com.company.Packing;

import com.company.Products.Product;

public interface PackingDecorator extends Product {
    int getPrice();
    String getDescription();
}
