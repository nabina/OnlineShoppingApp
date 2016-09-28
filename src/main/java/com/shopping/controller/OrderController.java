package com.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopping.model.Address;
import com.shopping.model.Order;
import com.shopping.model.Product;
import com.shopping.model.ProductProxy;
import com.shopping.service.OrderService;

@Controller
@Transactional
//@RequestMapping(value = "/")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value={"/addcart","/product/viewproduct/addcart"}, method=RequestMethod.POST)
	public void addItemToCart(@ModelAttribute ProductProxy productItem, HttpServletRequest request, HttpServletResponse response){
		
		orderService.addToCart(productItem, request);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}
	
	@RequestMapping(value="/showcart", method=RequestMethod.GET)
	public ModelAndView viewCart(ModelAndView model, HttpServletRequest request){
		Order cart = (Order) request.getSession().getAttribute("cart"); //get cart object from session
		model.addObject("cart", cart); //add Cart to model
		model.setViewName("showcart"); //display cart
		return model;	
	}
	
	
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public ModelAndView placeOrder(/*@ModelAttribute Address shippingAddress, */ModelAndView model, HttpServletRequest request, Authentication authentication, RedirectAttributes redirectAttrs){
		
		Order cart = (Order) request.getSession().getAttribute("cart");
		String customerId = "iroko116";//authentication.getName();
		cart.setCustomerId(customerId);//save order into database
		System.out.println(cart);
		
		
		orderService.placeOrder(cart);
		
		redirectAttrs.addFlashAttribute("cart", cart);
		request.getSession().removeAttribute("cart");
		model.setViewName("redirect:/checkout/success");
		return model;
	}
	
	@RequestMapping(value="/checkout/success", method=RequestMethod.GET)
	public ModelAndView reviewOrder(ModelAndView model){
		
		model.setViewName("checkout_success");
		return model;
	}

	
	/*@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showProducts(ModelAndView model){
		
		model.setViewName("productdummy");
		return model;
	}*/
}
