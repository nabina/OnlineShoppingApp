package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.Address;

import com.shopping.model.Customer;


@Repository
@Transactional
public class CustomerService {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	

	
	@Transactional(/*propagation=Propagation.REQUIRED*/)
	public void addCustomer(Customer customer){
		customer.getRoles().add("ROLE_USER");
		System.out.println("Before Save");
		System.out.println(customer);
		Session  session =sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		session.flush();
		//customerList.add(customer);
		//System.out.println(customerList);
	}
	
	public Customer findByUsername(String username) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, username);
    }
	
	public String changePassword(String newPassword ){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String currentUsername = auth.getName(); //get logged in username
	     Customer customer = this.findByUsername(currentUsername);
	     customer.setPassword(newPassword);
	     Session  session =sessionFactory.getCurrentSession();
		 session.saveOrUpdate(customer);
		 session.flush();
		 return currentUsername;
	}

}
