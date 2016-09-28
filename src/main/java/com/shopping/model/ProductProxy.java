package com.shopping.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ProductProxy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int productId;
	private String productName;
	private double price;
	private int qty;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
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
		
		return (((ProductProxy)o).getProductId() == this.productId);
	}
	
	@Override
	public int hashCode(){
		return String.valueOf(this.productId).hashCode();
	}
	
	@Override
	public String toString(){
		
		return "Values: \n" +  this.productId + ":" + this.getProductName() + ":" + this.getQty();
	}

}
