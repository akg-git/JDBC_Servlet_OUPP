<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<i>Page Scope:  after redirection to Page2, the name variable of is unavailable in pag2.</i>
		<i>Note: Browser stores the values temporarily as key-value pair. So we have get the value by using key of name variable.</i><br><br>
		<b>Page scoped variable (Page2): <%= pageContext.getAttribute("nameKey") %></b>
	</p>

</body>
</html>