package com.shopping.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Orders")
public class Order {
	
	@GeneratedValue
	@Id
	private int id;
	private int customerId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	private double orderValue;
	//private Customer customer;
	//private Collection<Product> productList = new ArrayList<Product>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/*public Collection<ProductDTO> getProductList() {
		return productList;
	}
	public void setProductList(Collection<ProductDTO> productList) {
		this.productList = productList;
	}*/
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}
	
	

}
