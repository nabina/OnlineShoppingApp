package com.shopping.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

public class ProductDTO {
	
	private int productId;
	private String productName;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public boolean equals(Object o){
		
		return (((ProductDTO)o).getProductId() == this.productId);
	}
	
	@Override
	public int hashCode(){
		return String.valueOf(this.productId).hashCode();
	}

}
