package com.ncs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ncs.service.UserService;
import com.ncs.service.UserServiceImpl;


public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter browser = resp.getWriter();
		
		UserService usrService = new UserServiceImpl();
		
		String username = req.getParameter("username");
		String password = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		String securityAnswer = req.getParameter("sa");
		
		try {
			if(password.equals(confirmPassword)) {
				boolean status = usrService.resetPassword(username, confirmPassword, securityAnswer);
				if(status == true) {
					browser.print("Password has been reset successfully");
					browser.print("<br/><a href='/Task3/Login.jsp'>Login page</a>");
				}else {
					browser.print("Unknown error");
				}
			}else {
				try {
					throw new Exception("password does not match");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
