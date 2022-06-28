<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="com.ncs.model.Products"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<%
		List<Products> product = (List<Products>)session.getAttribute("products");
	%>
	<p style="font-weight:bold;">Search List</p>
	
	<% for(Products p : product) 
	{
		%>
			<div>
				<div style="display:flex; width:50%; justify-content:space-between">
				<%=p.getProductName() %>
				<span>
					SGD <%=p.getProductPrice() %>
				</span>
				</div>
			</div>	
		<%
	}
	%>

</body>
	
</html>