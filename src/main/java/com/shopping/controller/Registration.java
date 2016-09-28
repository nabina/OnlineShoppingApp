package com.shopping.controller;



import java.util.Map;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.model.Customer;

import com.shopping.service.CustomerService;
import com.shopping.validator.CustomerValidator;

@Controller
public class Registration {
	
	@Autowired
	CustomerService customerService;
	
	 @Autowired
	  CustomerValidator customerValidator;
	
//	 @Autowired
//	 @Qualifier("authMgr")
//	 private AuthenticationManager authMgr;
	 
	  @Autowired
	  private UserDetailsService userDetailsSvc;
	
	@RequestMapping(value ="/registration", method = RequestMethod.GET)
	public String registration(Map<String, Object> model) {
	  Customer customer = new Customer();
	  model.put("customer", customer);
	  return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer,
            BindingResult result, Map<String, Object> model) {
		System.out.println(customer);
		 customerValidator.validate(customer, result);
	     if(result.hasErrors()){
	    	 return "registration";
	     }else{
	    	 customerService.addCustomer(customer); 
	    	// perform login authentication
	    	    try {
	    	      UserDetails userDetails = userDetailsSvc.loadUserByUsername(customer.getUsername());
	    	      UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	    	      SecurityContextHolder.getContext().setAuthentication(auth);
	    	 
//	    	      // redirect into secured main page if authentication successful
//	    	      if(auth.isAuthenticated()) {
//	    	        SecurityContextHolder.getContext().setAuthentication(auth);
//	    	        return "redirect:/";
//	    	      }
	    	    } catch (Exception e) {
	    	      //logger.debug("Problem authenticating user" + registrationDetail.getUsername(), e);
	    	    }
	    	    return "redirect:/";
	    	
	     }
		
	}
	
	
   public CustomerValidator getCustomerValidator() {
        return customerValidator;
    }
 
    public void setCustomerValidator(CustomerValidator customerValidator) {
        this.customerValidator = customerValidator;
    }

}
