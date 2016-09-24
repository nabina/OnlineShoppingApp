package com.shopping.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.model.Customer;

@Controller
public class Registration {
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		Customer customer = new Customer(); 
		model.addAttribute("customer", customer);
		return "registration";
	}

}
