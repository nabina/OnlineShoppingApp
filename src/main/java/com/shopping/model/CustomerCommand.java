package com.shopping.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class CustomerCommand {
	@NotEmpty(message="First Name can not be empty")
	private String firstName;
	
	@NotEmpty(message="Last Name can not be empty")
	private String lastName;
	
	@NotEmpty(message="Email can not be empty")
	@Email(message="Email is invalid")
	private String email;
	
	@NotEmpty(message="Username can not be empty")
	@Size(min = 6, max = 20)
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotEmpty(message="password can not be empty")
	private String password;
	
	
	private String confirmPassword;
	
	@NotEmpty(message="Phone Number can not be empty")
	private String phone;
	
	@NotEmpty(message="City can not be empty")
	private String city;
	
	@NotEmpty(message="Zip codecan not be empty")
	private String zipCode;
	@NotEmpty(message="State can not be empty")
	private String State;
	@NotEmpty(message="Country can not be empty")
	private String country;
	
	public CustomerCommand(){
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
