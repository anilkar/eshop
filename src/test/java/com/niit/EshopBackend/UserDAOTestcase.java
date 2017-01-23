package com.niit.EshopBackend;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class UserDAOTestcase {

	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User  user;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	
	@BeforeClass  //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		
		context = new  AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		
		context.refresh();
		
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	@Test
	public void getUserTestCase()
	{
		
		user = userDAO.get(1);
		
		
		//Assert statements
	  Assert.assertNotNull("getUserTestCase", user);
		
	}
	
	
	@Test
	public void validateCredentials()
	{
	user=	userDAO.validate(1234, "niit");
	 Assert.assertNotNull("validateCredentials", user);
	}
	
	
	@Test
	public void inValidateCredentials()
	{
	user=	userDAO.validate(123, "Vibhav");
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
		
		user.setId(3);
		user.setName("anil");
		user.setContact("943837742");
		user.setEmail("anil.kar18@gmail.com");
		user.setPassword("12345");
		user.setRole("ROLE_USER");
		
		
	 Assert.assertEquals("saveTestCase", true, 	userDAO.save(user));
		
	}
	
	
	@Test
	public void updateTestCase()
	{
		
	
		user = userDAO.get(2);
		user.setEmail("shidds@gmail.com");
		//user.setmail("Sidds@yahoo.com");
		
	 Assert.assertEquals("updateTestCase", true, 	userDAO.update(user));
		
		
	}
		

}


