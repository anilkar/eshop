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

	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category get(String catid) {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean save(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	public Category validate(String catid, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
