package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

public class UserDAOimpl implements UserDAO {
	
	
	@Autowired
    private SessionFactory sessionFactory;
	private String hq1;
	
	public UserDAOimpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	
	}
	
	public List<User> list() {
		setHq1("from User");
		String hq1 = null;
		@SuppressWarnings("unchecked")
		Query<User> query = sessionFactory.getCurrentSession().createQuery(hq1);
		return query.list();
		
	}

	public User get(String id) {
	
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
		}

	@SuppressWarnings("unchecked")
	public User validate(String id, String password) {
	String hq1 = "From user where id ='" + id +"' and password='" + password + "'";
	Query<User> query =sessionFactory.getCurrentSession().createQuery(hq1);
	return (User)query.uniqueResult();
	}

	public boolean save(User user) {
	
		try{
			 sessionFactory.getCurrentSession().save(user);
		}catch (Exception e){
			e.printStackTrace();	
	return false;
	}
    return true;
	}

	 public boolean update(User user)
	 {
		 
		 return true;
	 }

	public String getHq1() {
		return hq1;
	}

	public void setHq1(String hq1) {
		this.hq1 = hq1;
	}
	
	}
	