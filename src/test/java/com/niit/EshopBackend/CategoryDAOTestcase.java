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
	static CategoryDAO CategoryDAO;
	
	@Autowired
	static Category  Category;
	
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
		
		Category = (Category) context.getBean("Category");
		
		CategoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
	}
	

	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for Category
		
		
		Category.setCatid("c002");
		Category.setCatname("shop");
		Category.setCatdesc("laptop");
	
		
		
	 Assert.assertEquals("saveTestCase", true, 	CategoryDAO.save(Category));
		
	}
}





