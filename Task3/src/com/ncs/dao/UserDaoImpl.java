package com.ncs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ncs.model.User;

public class UserDaoImpl implements UserDao {
	
	Connection con; 
	
	public UserDaoImpl() {
		con = MySQLConnection.mySql;
			}

	@Override
	public boolean saveUser(User u) throws SQLException {
		
		String query = "insert into user(username, userPassword, securityQuestion, securityAnswer)values(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getUserPassword());
		ps.setString(3, u.getSecurityQuestion());
		ps.setString(4, u.getSecurityAnswer());
		
		int rowsAffected = ps.executeUpdate();
		
		boolean status = (rowsAffected == 1)?true:false;
		return status;
	}

	@Override
	public User findByUsernamePassword(String username, String password) throws SQLException {
		
		User u = new User();
		String query = "select * from user where username=? and userPassword=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setUserPassword(rs.getString("userPassword"));
			u.setSecurityQuestion(rs.getString("securityQuestion"));
			u.setSecurityAnswer(rs.getString("securityAnswer"));
		}
		return u;
	}

	@Override
	public boolean resetPassword(String username, String password, String sa) throws SQLException {
		
		String query = "update user set userPassword = ? where username= ? and securityAnswer = ? ";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, password);
		ps.setString(2, username);
		ps.setString(3, sa);
		
		int rowAffected = ps.executeUpdate();
		boolean status = (rowAffected == 1)?true:false;
		return status;
	}

	@Override
	public boolean updatePassword(String password, int id) throws SQLException {
		String query = "update user set userPassword = ? where id= ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, password);
		ps.setInt(2, id);
		
		int rowAffected = ps.executeUpdate();
		boolean status = (rowAffected == 1)?true:false;
		return status;
	}
}
