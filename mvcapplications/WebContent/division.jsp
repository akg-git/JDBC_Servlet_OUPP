<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Division </title>
</head>
<body>
	<%@ page errorPage="divisionExceptionTest.jsp" %>
	<%
		int num1 = Integer.parseInt(request.getParameter("firstnum"));
		int num2 = Integer.parseInt(request.getParameter("secondnum"));
		
		out.println("Division Result = "+ (num1/num2) );
	
	%>

</body>
</html>