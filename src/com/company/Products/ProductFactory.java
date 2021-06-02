package com.company.Products;

import com.company.Exceptions.ProductNotExistException;

public interface ProductFactory {
    Product createProduct(String name, int price) throws ProductNotExistException;
}
