package com.shopping.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopping.model.Customer;
import com.shopping.model.Password;
import com.shopping.service.CustomerService;

import com.shopping.validator.PasswordValidator;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerService;

	 @Autowired
	 PasswordValidator passValidator;
	
	@RequestMapping(value="myProfile/{username}",method=RequestMethod.GET)
	public String showMyProfile(@PathVariable String username,Map model){
		Customer customer =customerService.findByUsername(username);
		model.put("customer", customer);
		return "profile";
	}
	
	@RequestMapping(value="myProfile/changePassword")
	public String showPasswordForm(Map<String, Object> model){
		Password password = new Password();
		model.put("password", password);
		return "changePassword";
	}
	
	@RequestMapping(value="myProfile/changePassword",method=RequestMethod.POST)
	public String changePassword(@Valid @ModelAttribute("password") Password password,
            BindingResult result, Map<String, Object> model,RedirectAttributes redirectAttrs) {
		
		passValidator.validate(password, result);
	     if(result.hasErrors()){
	    	 return "changePassword";
	     }else{
	    	String username = customerService.changePassword(password.getNewPassword());
	    	redirectAttrs.addFlashAttribute("msg", "Successfully change  password.");
	    	return "redirect:/myProfile/"+username;
	     }
		
	}

	
	
	
	

}
