package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.model.Product;


@Repository("productDAO")
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
	public boolean save(Product product) {
		try {
			System.out.println("e1");
			sessionFactory.getCurrentSession().save(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@Transactional
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(Product product) {
		try{
			sessionFactory.getCurrentSession().delete(product);
			
			}
catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean create(Product product) {
		try{
			sessionFactory.getCurrentSession().delete(product);
			
			}
catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	}