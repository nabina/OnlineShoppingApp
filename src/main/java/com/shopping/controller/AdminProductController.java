package com.shopping.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import com.shopping.model.Product;
import com.shopping.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String viewAdmin(Model model) {
		return "admin";
	}

	@RequestMapping("/productInventory")
	public String productInventory(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "productInventory";
	}

	@RequestMapping("/productInventory/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
	     //product.setProductCategory("test");
		//product.setProductName("test");
		product.setProductCondition("new");
		product.setProductStatus("active");
		model.addAttribute("product", product);
		return "addProduct";
	}

	Path path;

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (result.hasErrors()){
			System.out.println("errorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
			return "addProduct";
		}
		productService.addProduct(product);
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

		if (productImage != null && !productImage.isEmpty()) {
			productImage.transferTo(new File(path.toString()));
		}

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/productInventory/deleteProduct/{productId}")
	public String deletProduct(@PathVariable int productId, Model model, HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		Product product = productService.getProductById(productId);
		productService.deleteProduct(product);
		System.out.println("test");
		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/productInventory/editProduct/{productId}")
	public String editProduct(@PathVariable int productId, Model model) {

		Product product = productService.getProductById(productId);

		model.addAttribute(product);

		return "editProduct";
	}

	@RequestMapping(value = "/productInventory/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute("product") Product product,BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()){
			return "editProduct";
		}
		
		MultipartFile productImage = product.getProductImage();

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		if (productImage != null && !productImage.isEmpty()) {

			try {
				productImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		productService.editProduct(product);

		return "redirect:/admin/productInventory";
	}

}
