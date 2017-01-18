package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {


    public List<User> list();
    public User get(int id);
    public User validate(int id, String password);
    public boolean save(User user);
    public boolean update(User user);
    
    
}