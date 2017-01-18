package com.niit.EshopBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

import junit.framework.Assert;

public class ProductDAOTestcase {

	//Autowire - DAO, DO, context
	
	
	@Autowired
	static ProductDAO ProductDAO;
	
	@Autowired
	static Product  Product;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	//Previously we written constructor
	//But in Junit we need to write a method
	//this method should call automatically when JUnit Test case run
	@BeforeClass   //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		
		context = new  AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		
		context.refresh();
		
		Product = (Product) context.getBean("Product");
		
		ProductDAO = (ProductDAO) context.getBean("ProductDAO");
	}
	

	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for Product
		

		Product.setPid("C001");
		product.setName("Electronics");
		product.setPrice(10000);
		product.setCategory("Smart phone");
		product.setSupplier("DS Telecommunication");
		product.setStock()
		product.setDescription("Mobiles");
		
	 Assert.assertEquals("saveTestCase", true, 	ProductDAO.save(Product));
		
	}
}
