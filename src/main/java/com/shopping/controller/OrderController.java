package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.shopping.model.Cart;
import com.shopping.service.OrderService;

@Controller
@SessionAttributes({"cart"})
@RequestMapping(value = "/cart")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="show", method=RequestMethod.POST)
	public ModelAndView viewOrder(@ModelAttribute("cart") Cart cart, ModelAndView model){
		
		model.addObject("cart", cart);
		model.setViewName("showcart");
		return model;
	}
	
	@Transactional
	@RequestMapping(value="checkout", method=RequestMethod.POST)
	public ModelAndView placeOrder(ModelAndView model, HttpServletRequest request){
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//save order into database
		orderService.placeOrder(cart);
		model.setViewName("checkout");
		return model;
	}

}
