package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;


public interface CategoryDAO {

	
	 public List<Category> list();
	    public Category get(String catid);
	    public boolean save(Category category);
	    public boolean update(Category category);
	    
	
	
}
