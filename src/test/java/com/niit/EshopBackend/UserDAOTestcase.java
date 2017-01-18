package com.niit.EshopBackend;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class UserDAOTestcase {

	//Autowire - DAO, DO, context
	
	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User  user;
	
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
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for user
		
		user.setId(2);
		user.setName("sam");
		user.setContact("943837742");
		user.setMail("anil.kar18@gmail.com");
		user.setPassword("123456");
		user.setRole("ROLE_USER");
		
		
	 Assert.assertEquals("saveTestCase", true, 	userDAO.save(user));
		
	}
}
