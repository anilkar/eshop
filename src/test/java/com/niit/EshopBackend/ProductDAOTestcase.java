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
	static ProductDAO productDAO;
	
	@Autowired
	static Product  product;
	
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
		
		product= (Product) context.getBean("Product");
		
		productDAO = (ProductDAO) context.getBean("ProductDAO");
	}
	

	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for Product
		

	
	
		product.setPid("C002");
		product.setName("Electronics");
		product.setPrice(10000);
		product.setCategory("c001");
		product.setSupplier("Gupta Distributor");
		product.setStock("5000");
	
		
		
		
		 Assert.assertEquals("saveTestCase", true, 	productDAO.save(product));
			
		}
		
		
		
		
	}