package com.niit.EshopBackend;

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
	static UserDAOTestcase userDAO;
	
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
		
		userDAO = (UserDAOTestcase) context.getBean("userDAOImpl");
		 
	}
	
	@Test
	public void getUserTestCase()
	{
		
		user = UserDAO.get("niit");
		
		
		//Assert statements
	  Assert.assertNotNull("getUserTestCase", user);
		
	}
	
	
	@Test
	public void validateCredentials()
	{
	user=	userDAO.validate("niit", "niit");
	 Assert.assertNotNull("validateCredentials", user);
	}
	
	
	@Test
	public void inValidateCredentials()
	{
	user=	userDAO.validate("Vibhav", "Vibhav");
	 Assert.assertNull("inValidateCredentials", user);
	 
	 //OR
	// Assert.assertEquals("inValidateCredentials", null , user );
	 
	}
	
	
	
	@Test
	public void getAllUsersTestCase()
	{
	 int size=	userDAO.list().size();
	 Assert.assertEquals(" length check ", 8 , size);
	 
	 
	}
	
	
	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for user
		
		user.setId("Chirutha");
		user.setName("Chirutha");
		user.setContact("989898989");
		user.setMail("Chirutha@gmila.com");
		user.setPassword("Chirutha");
		user.setRole("ROLE_USER");
		
		
	 Assert.assertEquals("saveTestCase", true, 	userDAO.save(user));
		
	}
	
	
	@Test
	public void updateTestCase()
	{
		
	
		user = userDAO.get("Sai");
		
		user.setMail("Sai@yahoo.com");
		
	 Assert.assertEquals("updateTestCase", true, 	userDAO.update(user));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
