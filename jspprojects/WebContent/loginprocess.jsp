<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login process JSP File</title>
</head>
<body>

	<%
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("abc") && password.equals("10")){
			/* response.sendRedirect("welcome.jsp"); */
			response.sendRedirect("https://www.google.com"); 
		}else{
			out.print("Message: Sorry!! Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	
	%>

</body>
</html>