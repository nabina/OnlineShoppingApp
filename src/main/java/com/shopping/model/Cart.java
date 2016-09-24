package com.shopping.model;

import java.util.ArrayList;
import java.util.Collection;

public class Cart {
	
	private Collection<ProductDTO> productList = new ArrayList<ProductDTO>();
	
	private double totalValue;
	
	public Collection<ProductDTO> getProductList() {
		return productList;
	}
	public void setProductList(Collection<ProductDTO> productList) {
		this.productList = productList;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	public void addItem(ProductDTO product){
		this.productList.add(product);
	}
	
	public boolean removeItem(ProductDTO product){
		return this.productList.remove(product);
	}
	
}
