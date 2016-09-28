package com.shopping.validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shopping.model.Customer;

import com.shopping.service.CustomerService;

@Component
public class CustomerValidator implements Validator {
	@Autowired
    private CustomerService customerrService;

	/**
     * This Validator validates *just* CustomerCommand instances
     */
	@Override
	public boolean supports(Class<?> myclass) {
		// TODO Auto-generated method stub
		return Customer.class.equals(myclass);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "confirmPassword"," ","MY confirmpassword can  not be empty");
		Customer customer = (Customer) obj;
        if (!customer.getPassword().equals(customer.getConfirmPassword())) {
        	e.rejectValue("confirmPassword","", "Confirm password doesn't match with password");
        	
        } 
        
        
		
        if (customerrService.findByUsername(customer.getUsername()) != null) {
        	e.rejectValue("username","", "Duplicate User name");
        }
	}

	

}
