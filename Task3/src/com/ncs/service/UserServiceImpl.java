package com.ncs.service;

import java.sql.SQLException;

import com.ncs.dao.UserDao;
import com.ncs.dao.UserDaoImpl;
import com.ncs.model.User;

public class UserServiceImpl implements UserService {
	UserDao usrDao;
	public UserServiceImpl(){
		usrDao = new UserDaoImpl();
	}
	@Override
	public boolean saveUser(User s) throws SQLException {
		boolean status = usrDao.saveUser(s);
		return status;
	}
	@Override
	public User findByUsernamePassword(String username, String password) throws SQLException {
		User u = usrDao.findByUsernamePassword(username, password);
		return u;
	}
	@Override
	public boolean resetPassword(String username, String password, String sa) throws SQLException {
		boolean status = usrDao.resetPassword(username, password, sa);
		return status;
	}
	@Override
	public boolean updatePassword(String password, int id) throws SQLException {
		boolean status = usrDao.updatePassword(password,id);
		return status;
	}

}
