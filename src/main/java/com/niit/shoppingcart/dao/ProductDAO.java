package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();
	public Product get(String pid);
	 public boolean save(Product product);
     public boolean update(Product product);
     public boolean delete(Product product);
	public boolean create(Product product);
	
	
	
}