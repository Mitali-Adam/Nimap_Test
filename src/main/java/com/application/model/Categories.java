package com.application.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoriesId;
	private String Name;
	
	
	@OneToMany(mappedBy ="categories" , cascade = CascadeType.ALL)
	 private Set<Product> product;
	 
	 
	 
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Categories(String name) {
		super();
		Name = name;
	}
	
	 public Categories()
	 {
		 
	 }
	@Override
	public String toString() {
		return "Categories [categoriesId=" + categoriesId + ", Name=" + Name + "]";
	}
	
	   
}
