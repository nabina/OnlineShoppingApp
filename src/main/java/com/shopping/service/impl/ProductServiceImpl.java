package com.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.ProductDao;
import com.shopping.model.Product;
import com.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    
	@Override
	public List<Product> getProductList() {
		 return productDao.getAllProduct();
	}

	@Override
	public Product getProductById(int productId) {
		 return productDao.getProductById(productId);
	}

	@Override
	public void addProduct(Product product) {
		 productDao.addProduct(product);
		
	}

	@Override
	public void editProduct(Product product) {
		productDao.editProduct(product);
		
	}

	@Override
	public void deleteProduct(Product product) {
		  productDao.deletProduct(product);
		
	}



}
