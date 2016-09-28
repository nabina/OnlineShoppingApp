package com.shopping.service;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.Order;
import com.shopping.model.ProductProxy;

@Transactional
@Component
public class OrderService {

	@Autowired
	SessionFactory sessionFactory;

	public void placeOrder(Order cart/* , String customerId */) {

		// cart.setCustomerId(customerId);
		Session session = sessionFactory.getCurrentSession();// openSession();		
		
		cart.setOrderValue(cart.getOrderValue());
		cart.setOrderDate(cart.getOrderDate());
		cart.setItemCount(cart.getProductList().size());
		session.persist(cart);
	}

	public void addToCart(ProductProxy productItem, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Order cart = (Order) session.getAttribute("cart");// get Cart object
															// from current
															// session
		if (cart == null)
			cart = new Order(); // create new Cart object if none exists
		cart.addItem(productItem); // add product to cart
		session.setAttribute("cart", cart); // update session attribute
	}

}
