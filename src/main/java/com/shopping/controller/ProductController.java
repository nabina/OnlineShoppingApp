package com.shopping.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.dao.ProductDao;
import com.shopping.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping("/productlist")
	public String getProducts(Model model) {
		List<Product> products = productDao.getAllProduct();
		System.out.println(products);
		model.addAttribute("products", products);

		return "productlist";
	}

	@RequestMapping("/product/viewproduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws IOException {
		Product product = productDao.getProductById(productId);
		model.addAttribute(product);

		return "viewproduct";
	}

}
