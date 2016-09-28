package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Car {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	 public Car(){
		 
	 }
	 
   public Car(String name){
		 this.name=name;
	 }
	 
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
