package com.shopping.dao;

import java.util.List;

import com.shopping.model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	
	Product getProductById(int productId);
	
	List<Product> getAllProduct();
	
	void deletProduct(Product product);
	
	void editProduct(Product product);
}
