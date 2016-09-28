package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@NotEmpty(message = "Please Enter Product Name")
	private String productName;
	private String productCategory;
	private String productDescription;
	@Min(value = 0, message = "The product price must not be less then zero")
	private double productPrice;
	private String productCondition;
	private String productStatus;
	@Min(value = 0, message = "The product unit must not be less then zero")
	private int    productUnitInStock;
	private String productManufacture;
	@Transient
	private MultipartFile productImage; 
	

	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getProductUnitInStock() {
		return productUnitInStock;
	}
	public void setProductUnitInStock(int productUnitInStock) {
		this.productUnitInStock = productUnitInStock;
	}
	public String getProductManufacture() {
		return productManufacture;
	}
	public void setProductManufacture(String productManufacture) {
		this.productManufacture = productManufacture;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productCategory=" + productCategory + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productCondition=" + productCondition
				+ ", productStatus=" + productStatus + ", productUnitInStock=" + productUnitInStock
				+ ", productManufacture=" + productManufacture + "]";
	}
	
	
	
	

}
