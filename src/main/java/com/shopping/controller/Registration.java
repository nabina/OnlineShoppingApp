package com.shopping.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.model.Customer;
import com.shopping.service.CustomerService;

@Controller
public class Registration {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		Customer customer = new Customer(); 
		model.addAttribute("customer", customer);
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public void addCustomer(Customer customer) {
		System.out.println(customer);
		//customerService.addCustomer(customer);
	}

}
