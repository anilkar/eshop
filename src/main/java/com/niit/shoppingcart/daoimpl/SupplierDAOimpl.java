package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;

import com.niit.shoppingcart.model.Supplier;

@Repository
public class SupplierDAOimpl implements SupplierDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
			
	}
	
	@Transactional
	public List<Supplier> list() {
		String hql = "from Supplier";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
	
	@Transactional
	public Supplier get(String sid) {
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, sid);

	}
	@Transactional
	public boolean save(Supplier Supplier) {
		try {
			sessionFactory.getCurrentSession().save(Supplier);
		} catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		return false;
	}

	

	public boolean update(Supplier Supplier) {
		try {
			sessionFactory.getCurrentSession().update(Supplier);
		
	}
		return false;
}