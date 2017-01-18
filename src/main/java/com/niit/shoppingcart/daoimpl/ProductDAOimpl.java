package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Repository
public class ProductDAOimpl implements ProductDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Product> list() {
		String hql = "from Product";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	@Transactional
	public Product get(String pid) {

		return (Product) sessionFactory.getCurrentSession().get(Product.class, pid);

	}
	
	


	@Transactional
	public boolean save(Product Product) {
		try {
			sessionFactory.getCurrentSession().save(Product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}


			
		
	public Product (String pid, String password) {
		try {
			sessionFactory.getCurrentSession().update(ProductDAOimpl);
	public Product validate(String pid, String password) {
		// TODO Auto-generated method stub
		return null;
	}
		}
		
		
		
		
		
		
		