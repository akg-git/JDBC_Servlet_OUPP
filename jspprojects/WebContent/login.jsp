<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login JSP File</title>
</head>
<body>

	<form action="loginprocess.jsp">
		<table>
		
			<tr>
				<td>UserName</td>
				<td><input type="text" name = "username" placeholder="username"></td>
			</tr><br>
			<tr>
				<td>Password</td>
				<td><input type="password" name = "password" placeholder = "password"></td>
			</tr><br>
			<tr>
				<td><input type="button" name = "cancel" value="cancel"></td>
				<td><input type="submit" name = "submit" value="login"></td>
			</tr>
		
		</table>
	</form>

</body>
</html>