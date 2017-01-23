package com.niit.EshopBackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.model.Product;

public class ProductDAOTestcase {
	
	
public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
			
		
	   ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
	   
	   Product product = 	(Product) context.getBean("product");
	   
	   product.setPid("C002");
	   product.setName("mobiles");
	   product.setPrice(50000);
	   product.setCatid("C001");
	   product.setSid("S002");
	   productDAO.save(product);
	   
	   
	   System.out.println("er6");
	   
	   
	   
	
		
		
		
	}

	
	
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static Product product;

	@Autowired
	static ProductDAO productDAO;

	

	@BeforeClass
	public static void init()
	{
    context  = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	productDAO  = (ProductDAO) context.getBean("productDAO");
	product =(Product) context.getBean("product");
	System.out.println("the objects are created");
	}
	@Test
	public void createProductTestCase()
	{
	product.setPid("P005");
	product.setName("handbag");
	product.setPrice(4000);
	product.setCatid("C001");
    product.setSid("SOO1");
	Boolean status=productDAO.save(product);
	Assert.assertEquals("createProductDAOTestCase",true,status);
	}
	@Test
	public void deleteProductTestCase()
	{
	product.setPid("P002");
	product.setName("dress");
	product.setPrice(3000);
	product.setCatid("C001");
    product.setSid("SOO1");
	Boolean status=productDAO.delete(product);
	Assert.assertEquals("deleteProductDAOTestCase",true,status);
	}
	@Test
	public void updateProductTestCase()
	{
	product.setPid("P001");
	product.setName("bag");
	product.setPrice(3000);
	product.setCatid("C001");
    product.setSid("SOO1");
	Boolean status=productDAO.update(product);
	Assert.assertEquals("updateProductDAOTestCase",true,status);
	}
	
	
}