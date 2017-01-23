package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

@Repository
public class UserDAOimpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<User> list() {
		String hql = "from User";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}

	
	@Transactional
	public User get(int id) {

		return (User) sessionFactory.getCurrentSession().get(User.class, id);

	}

	@Transactional
	public User validate(int id, String password) {
		String hql = "from User where id ='" + id + "'  and password='" + password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return (User) query.uniqueResult();
}

	@Transactional
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	

}