<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	
	<%
		String name = "asish";
		pageContext.setAttribute("nameKey", name);
	%>
	
	<p>
		<i>Page Scope: scope of name variable; it will not visible in next page after redirected to Page2</i><br><br>
		<b>Second Page Variable(page 1):</b><br>
		name = <%= name %><br>
		<a href="page2.jsp">Go to page2</a>
	</p>
</body>
</html>