package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;
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
		String hql = "from Products";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
	
	@Transactional
	public Product get(String pid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, pid);

	}
	
	@Transactional
	public boolean save(Product products) {
		try {
			System.out.println("data inserted");
			sessionFactory.getCurrentSession().save(products);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@Transactional
	public boolean update(Product products) {
		try {
			sessionFactory.getCurrentSession().update(products);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}		