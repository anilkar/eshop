package com.niit.shoppingcart.daoimpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.User;

@Repository
public class CategoryDAOimpl implements CategoryDAO {


	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Category> list() {
		String hql = "from Category";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	@Transactional
	public Category get(String catid) {

		return (Category) sessionFactory.getCurrentSession().get(Category.class, catid);

	}
	
	


	@Transactional
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

}