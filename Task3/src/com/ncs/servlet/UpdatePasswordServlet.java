package com.ncs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.service.UserService;
import com.ncs.service.UserServiceImpl;


public class UpdatePasswordServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter browser = resp.getWriter();
		
		UserService usrService = new UserServiceImpl();
		
		HttpSession session = req.getSession(true);
		int id = (int)session.getAttribute("userId");
		String password = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		
		try {
			if(password.equals(confirmPassword)) {
				boolean status = usrService.updatePassword(password, id);
				if(status == true) {
					browser.print("Password has been Updated successfully");
					browser.print("<br/><a href='/Task3/HomePage.jsp'>HomePage</a>");
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
