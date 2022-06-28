<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body>
<%
 String username = (String)session.getAttribute("username");
%>
<div style="background-color: gray; width: 100%;height: 10%">
	<div style="margin-left: 5%;">
		<form action="search" method="post">
		<table>
			<tr>
				<td><input type="text" name="keyword"><td>
				<td><input type="submit" value="Search"/></td>
			</tr>
		</table>
		</form>
	</div>
	<div style="margin-left: 75%; font-size:medium; color:white;">
		Welcome <%=username%>
	</div>
	<div style="margin-left: 75%; font-size:medium;">
		<a href="/Task3/OrderHistory.jsp">Order History</a>
		<a href="/Task3/UpdatePassword.jsp">Update Password</a>
	</div>
</div>
</body>
</html>