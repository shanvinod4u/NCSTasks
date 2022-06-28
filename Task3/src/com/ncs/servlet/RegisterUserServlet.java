package com.ncs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncs.model.User;
import com.ncs.service.UserService;
import com.ncs.service.UserServiceImpl;


public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter browser = resp.getWriter();
		
		String username = req.getParameter("username");
		String userPassword = req.getParameter("password");
		String sq = req.getParameter("sq");
		String sa = req.getParameter("sa");
		
		UserService usrService = new UserServiceImpl();
		User user = new User(username,userPassword,sq,sa);
		
		try {
			boolean status = usrService.saveUser(user);
			if(status == true) {
				browser.print("New user "+user.getUsername()+"'s data has been successfully added");
				browser.print("<br/><a href='/Task3/Login.jsp'>Login page</a>");
			}else {
				try {
					throw new Exception("Unknow error");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


