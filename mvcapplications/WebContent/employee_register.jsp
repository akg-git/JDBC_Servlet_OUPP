<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Register Page</title>
</head>
<body>

	<h1>Student Registration Form</h1>
	<form action="<%= request.getContextPath() %>/register" method="post">
		<table style="width:80%">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			<tr>
				<td>Username</td>
				<td><input type="text" name="userName"></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password"></td>
			</tr>
			
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
			</tr>
			
			<tr>
				<td>Contact</td>
				<td><input type="text" name="contact"></td>
			</tr>
			
			<tr>
			<td><input type = "button" name = "cancel" value="cancel"></td>
				<td><input type = "submit" name = "register" value="register"></td>
			</tr>
			
			
		</table>
	</form>

</body>
</html>