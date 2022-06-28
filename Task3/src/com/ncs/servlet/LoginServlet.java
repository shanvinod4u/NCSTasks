package com.ncs.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.User;
import com.ncs.service.UserService;
import com.ncs.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService usrService = new UserServiceImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User u = usrService.findByUsernamePassword(username, password);
			
			if(u!=null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", username);
				int id = u.getId();
				session.setAttribute("userId", id);
				response.sendRedirect("HomePage.jsp");
			}else {
				try {
					throw new Exception("Invalid username or password");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
