package com.shopping.model;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;


@Embeddable
public class Address {
	
	@NotEmpty(message="City can not be empty")
	private String city;
	@NotEmpty(message="Zip code can not be empty")
	private String zipCode;
	@NotEmpty(message="State can not be empty")
	private String state;
	@NotEmpty(message="Country can not be empty")
	private String country;
	
	public Address(){
		
	}
	

	public Address(String city, String zipCode, String state, String country) {
		super();
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
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
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", zipCode=" + zipCode + ", state=" + state + ", country=" + country + "]";
	}
}
