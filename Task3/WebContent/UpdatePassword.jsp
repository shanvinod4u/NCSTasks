<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"/>
	</div>
	<div style="width:40%; font-weight:bold; text-align:center;">
	<div>Update Password</div>
	<form action="updatePassword" method="post">
	<table>
		<tr>
			<td>New Password</td>
			<td><input type="text" name="newPassword"></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><input type="text" name="confirmPassword"></td>
		</tr>
		<tr>
			<td colspan=2><input type="submit" value="Update Password"></td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>