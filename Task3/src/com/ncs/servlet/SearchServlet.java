package com.ncs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ncs.model.Products;
import com.ncs.service.ProductService;
import com.ncs.service.ProductServiceImpl;
import com.ncs.service.UserService;
import com.ncs.service.UserServiceImpl;


public class SearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductService ps = new ProductServiceImpl();
		String keyword = req.getParameter("keyword");
		
		try {
			List<Products> products = ps.searchProducts(keyword) ;
			if(products != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("products", products);
				resp.sendRedirect("SearchPage.jsp");
				
			}else {
				try {
					throw new Exception(" No Products available named "+keyword);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
