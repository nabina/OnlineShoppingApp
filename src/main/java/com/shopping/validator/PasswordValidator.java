package com.shopping.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shopping.model.Customer;
import com.shopping.model.Password;
import com.shopping.service.CustomerService;

@Component
public class PasswordValidator implements Validator {
	@Autowired
    private CustomerService customerrService;

	
	 
	@Override
	public boolean supports(Class<?> cls) {
		// TODO Auto-generated method stub
		return Password.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "oldPassword"," ","Old Password can  not be empty");
		ValidationUtils.rejectIfEmpty(e, "newPassword"," "," New Password can  not be empty");
		ValidationUtils.rejectIfEmpty(e, "confirmPassword"," ","Confirmpassword can  not be empty");
		
		Password password = (Password) obj;
        if (!password.getNewPassword().equals(password.getConfirmPassword())) {
        	e.rejectValue("confirmPassword","", "Confirm password doesn't match with password");
        	
        } 
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = auth.getName(); //get logged in username
        Customer customer = customerrService.findByUsername(currentUser);
        
        if (!password.getOldPassword().equals(customer.getPassword())) {
        	e.rejectValue("oldPassword","", "Old password doesn't match ");
        	
        } 
	}

}
