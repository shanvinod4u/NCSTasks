<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ncs.service.ProductService"%>
<%@page import="com.ncs.service.ProductServiceImpl"%>
<%@page import="com.ncs.model.Products"%>
<%@page import="java.util.List"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order History</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"/>
	</div>
	<%	int id = (int)session.getAttribute("userId");
		String username = (String)session.getAttribute("username");
		ProductService ps = new ProductServiceImpl();
		List<Products> products = ps.getProductsByPurchased(id);
	%>
	<p style="font-weight:bold;">Order List</p>
	<% for(Products p : products) 
	{
		%>
		<div>
			<div style="display:flex; width:50%; justify-content:space-between">
				<%=p.getProductName() %>
				<span>
					SGD <%=p.getProductPrice() %>
				</span>
				<span>
					Purchased By: <%=username %>
				</span>
			</div>
		</div>
		<%
	}
	%>
</body>
</html>
