package com.niit.EshopBackend;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

import junit.framework.Assert;

public class CategoryDAOTestcase {

	//Autowire - DAO, DO, context
	
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static Category  category;
	
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
		
		category = (Category) context.getBean("Category");
		
		categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
	}
	

	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for Category
		
		
		category.setCatid("c001");
		category.setCatname("mobile");
		category.setCatdesc("qwerty");
	
		
		
	 Assert.assertEquals("saveTestCase", true, 	categoryDAO.save(category));
		
	}
}





