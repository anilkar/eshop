package com.niit.shoppingcart.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hamcrest.Description;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "product")
@Component
public class Product {

	

	@Id
	private String  pid;
	private String name;
	private String pcategory;
	private double price;
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getcatid() {
		return catid;
	}
	public void setcatid(String category_id) {
		this.catid = category_id;
	}
	

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}

	private String catid;
	
	
	private String sid;
	
	@ManyToOne
    @JoinColumn(name="category_id", nullable = false, updatable = false, insertable = false)
   	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@ManyToOne
    @JoinColumn(name="sid",nullable = false, updatable = false, insertable = false)
	private Supplier supplier;
	public String getId() {
		return sid;
	}
	public void setId(String id) {
		this.pid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcategory() {
		return pcategory;
	}
	public void setDescription(String description) {
		this.pcategory = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
