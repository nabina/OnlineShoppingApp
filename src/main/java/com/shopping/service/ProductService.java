package com.shopping.service;

import java.util.List;

import com.shopping.model.Product;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById (int productId);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

   
}
