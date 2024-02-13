<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Declaration JSP Tag</title>
</head>
<body>

	<!-- declare method using declaration tag -->
	<%!
		int cube(int n){
			return n*n*n;
		}
	%>
	
	<!-- declaration variable using declaration tag -->
	<%! int n=3; %>
	
	<!-- calling function using expression tag -->
	<%= 
		"Cube of "+n+" = "+cube(n)
	%>

</body>
</html>