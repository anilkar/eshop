package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.daoimpl.CategoryDAOimpl;
import com.niit.shoppingcart.daoimpl.ProductDAOimpl;
import com.niit.shoppingcart.daoimpl.ProductDAOimpl;
import com.niit.shoppingcart.daoimpl.SupplierDAOimpl;
import com.niit.shoppingcart.daoimpl.UserDAOimpl;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;


@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/anil");
	    
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");
	   
System.out.println("database");
	    return  dataSource;
	}
	
  private Properties getHibernateProperties()
  {
	  Properties properties =new Properties();
	 properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	properties.put("hbm2ddl.auto","update");
	  System.out.println("prop");
	  return properties;
  }
  @Autowired
  @Bean(name="sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource)
  {
	 LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource); 
	 
	 sessionBuilder.addProperties(getHibernateProperties());
	 
	 sessionBuilder.addAnnotatedClass(Category.class);
	 sessionBuilder.addAnnotatedClass(Supplier.class);
	 sessionBuilder.addAnnotatedClass(Product.class);
	 sessionBuilder.addAnnotatedClass(User.class);
	 System.out.println("session");
	 return sessionBuilder.buildSessionFactory();
  }
  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

      HibernateTransactionManager transactionManager = new   HibernateTransactionManager(sessionFactory);
     
      return transactionManager;
  }
  
  @Autowired
  @Bean(name = "categoryDAO")
  public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("catdao");
  	return new CategoryDAOimpl(sessionFactory);
  }
  @Autowired
  @Bean(name = "supplierDAO")
  public SupplierDAO getSupplierDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("dao");
  	return new SupplierDAOimpl(sessionFactory);
  }
  @Autowired
  @Bean(name = "productDAO")
  public ProductDAO getProductDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("dao");
  	return new ProductDAOimpl(sessionFactory);
  }
  @Autowired
  @Bean(name = "userDAO")
  public UserDAO getUserDAO(SessionFactory sessionFactory) 
	{
	  
	  System.out.println("dao");
  	return new UserDAOimpl(sessionFactory);
  }
}