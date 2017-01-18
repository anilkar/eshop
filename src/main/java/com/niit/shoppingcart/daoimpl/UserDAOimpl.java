package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;
@Repository
public class UserDAOimpl implements UserDAO {
	
	
	@Autowired
    private SessionFactory sessionFactory;
	private String hq1;
	
	public UserDAOimpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	
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
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	

}