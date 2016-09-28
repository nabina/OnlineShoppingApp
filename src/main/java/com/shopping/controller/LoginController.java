package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.model.User;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm(Model model){
		model.addAttribute("user", new User());
		return "login";
	}

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute User user){
		System.out.println(user.getEmail());
		return "login";
	}
}
