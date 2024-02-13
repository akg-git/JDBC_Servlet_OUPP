<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Portal</title>
</head>
<body>

	<form action="process.jsp">
		<table>
		
			<tr>
				<td>User ID</td>
				<td><input type="text" name = "id" placeholder="user id"></td>
			</tr><br>
			<tr>
				<td>Name</td>
				<td><input type="text" name = "name" placeholder="user name"></td>
			</tr><br>
			<tr>
				<td>Email</td>
				<td><input type="email" name = "email" placeholder="email id"></td>
			</tr><br>
			<tr>
				<td>Password</td>
				<td><input type="password" name = "password" placeholder = "password"></td>
			</tr><br>
			<tr>
				<td><input type="button" name = "cancel" value="cancel"></td>
				<td><input type="submit" name = "submit" value="register"></td>
			</tr>
		
		</table>
	</form>

</body>
</html>