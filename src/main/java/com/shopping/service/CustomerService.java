package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.Customer;

@Service
public class CustomerService {
	@Autowired
	private SessionFactory sessionFatory ;
	
	
	public void setSessionFatory(SessionFactory sessionFatory) {
		this.sessionFatory = sessionFatory;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	List<Customer> customerList= new ArrayList<Customer>();
	
	//@Transactional(propagation=Propagation.REQUIRED)
	public void addCustomer(Customer customer){
		System.out.println(customer);
		//sessionFatory.openSession().persist(customer);
	}

}
