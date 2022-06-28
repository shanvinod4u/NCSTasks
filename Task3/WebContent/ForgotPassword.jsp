<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
</head>
<body>
	<div style="width:40%; font-weight:bold; text-align:center;">
	<div>Forget Password</div>
	<form action="resetPassword" method="post">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>New Password</td>
			<td><input type="text" name="newPassword"></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><input type="text" name="confirmPassword"></td>
		</tr>
		<tr>
			<td>SecurityAnswer</td>
			<td><input type="text" name="sa"></td>
		</tr>

		<tr>
			<td colspan=2><input type="submit" value="Reset Password"></td>
		</tr>
		<tr>
			<td><a href="Login.jsp">Login Page</a></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>