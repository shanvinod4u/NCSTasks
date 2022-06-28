<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div style="width:40%; font-weight:bold; text-align:center;">
	<div>Login</div>
	<form action="login" method="post">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan=2><input type="submit" value="Login"></td>
		</tr>
		<tr>
			<td><a href="Register.jsp">Register User</a></td>
			<td><a href="ForgotPassword.jsp">Forget Password</a></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>