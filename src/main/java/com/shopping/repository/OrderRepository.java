package com.shopping.repository;

import java.util.List;

import org.hibernate.SessionFactory;

import com.shopping.model.Order;

public class OrderRepository{
	
	SessionFactory sessionFactory;

	public List<Order> getOrder(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean placeOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
