package com.shopping.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Orders")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String customerId;
	private int itemCount;

	@Temporal(TemporalType.DATE)
	private Date orderDate;

	private double orderValue;

	/*
	 * @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	 * 
	 * @JoinColumn(name="product_id")
	 */
	/*
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @JoinTable(name="Order_Map", joinColumns=@JoinColumn(name="Order_Id"),
	 * inverseJoinColumns=@JoinColumn(name="Product_Id"))
	 */
	// @ElementCollection
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	//@MapKey(name = "productId")
	private Map<Integer, ProductProxy> productList = new HashMap<Integer, ProductProxy>();
	/*
	 * @OneToOne private Cart cart;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public int getItemCount() {
		itemCount = this.productList.size();
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Map<Integer, ProductProxy> getProductList() {
		return productList;
	}

	public void setProductList(Map<Integer, ProductProxy> productList) {
		this.productList = productList;
	}

	public Date getOrderDate() {
		orderDate = Calendar.getInstance().getTime();
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderValue() {

		/*this.productList.forEach((k, v) -> {
			orderValue += v.getPrice();
		});*/
		orderValue = 0;
		for(ProductProxy p : this.productList.values()){
			orderValue += p.getPrice();
			
		}

		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public void addItem(ProductProxy product) {

		int pId = product.getProductId();
		
		if (this.productList.containsValue(product)){
			ProductProxy p = this.productList.get(pId);
			product.setQty(p.getQty()+product.getQty());
			this.productList.put(pId, product);
		}	
		this.productList.put(pId, product);
	}

	public boolean removeItem(ProductProxy product) {
		return this.productList.remove(product.getProductId(), product);
	}
	
	@Override
	public String toString(){
		
		return this.customerId + ": " + this.productList.toString();
	}

}
