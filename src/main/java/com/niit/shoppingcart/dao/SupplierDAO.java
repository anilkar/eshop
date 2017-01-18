package com.niit.shoppingcart.dao;


import java.util.List;

import com.niit.shoppingcart.model.Supplier;


public interface SupplierDAO {

	
	 public List<Supplier> list();
	    public Supplier get(String sid);
	    
	    public boolean save(Supplier Supplier);
	    public boolean update(Supplier Supplier);
	    
	
	
}
