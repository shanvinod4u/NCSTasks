package com.ncs.dao;

import java.sql.SQLException;

import com.ncs.model.User;

public interface UserDao {
	
	public boolean saveUser(User s) throws SQLException;
	public User findByUsernamePassword(String username, String password)throws SQLException;
	public boolean resetPassword(String username, String password, String sa) throws SQLException;
	public boolean updatePassword(String password, int id)throws SQLException;
}
