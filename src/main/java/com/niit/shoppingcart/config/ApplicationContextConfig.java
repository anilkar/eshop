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
System.out.println("db");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/anil");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		System.out.println("prop");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("sess");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);


		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("ses fac");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	@Autowired
    @Bean(name = "UserDAO")
    public UserDAO getUserDao(SessionFactory sessionFactory) 
	{
    	return new UserDAOimpl(sessionFactory);
    }

	@Autowired
    @Bean(name = "CategoryDAO")
    public CategoryDAO getCategoryDao(SessionFactory sessionFactory) 
	{
		return new CategoryDAOimpl(sessionFactory);
    }

	
	@Autowired
    @Bean(name = "ProductDAO")
    public ProductDAO getProductDao(SessionFactory sessionFactory) 
	{
		return new ProductDAOimpl(sessionFactory);
    }

	@Autowired
    @Bean(name = "SupplierDAO")
    public SupplierDAO getSupplierDao(SessionFactory sessionFactory) 
	{
		return new SupplierDAOimpl(sessionFactory);
    }

}
