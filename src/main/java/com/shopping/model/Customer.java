package com.shopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Entity(name="users")
public class Customer {
	@Id
	@NotEmpty(message="Username can not be empty")
	@Size(min = 6, max = 20)
	private String username;
	
	@NotEmpty(message="First Name can not be empty")
	private String firstName;
	
	@NotEmpty(message="Last Name can not be empty")
	private String lastName;
	
	@NotEmpty(message="Email can not be empty")
	@Email(message="Email is invalid")
	private String email;
	
	@NotEmpty(message="Phone can not be empty")
	private String phone;
	
	
	@Size(min = 6, max = 20)
	@NotEmpty(message="password can not be empty")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Valid
	@Embedded
	private  Address address;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	@ElementCollection
	@CollectionTable(name="user_roles", joinColumns=@JoinColumn(name="username"))
	
	private List<String> role = new ArrayList<String>();
	
	@ColumnDefault("1")
	private int enabled=1;
	
	
	
	
	
	public Customer(){
		
	}

	public List<String> getRoles() {
		return role;
	}



	public void setRoles(List<String> roles) {
		this.role = roles;
	}

	

	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}





	public int getEnabled() {
		return enabled;
	}



	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Customer [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", role=" + role
				+ ", enabled=" + enabled + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	
//	public String toString(){
//		return "UserName="+this.username+" password="+this.password+" enamail="+this.email+" FirstName =>"+
//	this.firstName+"  LastName =>"+this.lastName +", Address="+this.address.getCity()+
//	" "+ this.getAddress().getZipCode()+" "+this.getAddress().getState()+" "+this.getAddress().getCountry();
//	}

}
