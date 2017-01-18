package com.niit.shoppingcart.dao;


import java.util.List;

import com.niit.shoppingcart.model.Product;;


public interface ProductDAO {

	
	 public List<Product> list();
	    public Product get(String pid);
	    
	    public boolean save(Product Product);
	    public boolean update(Product Product);
	    
	
	
}
