<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Division Exception Test JSP File</title>
</head>
<body bgcolor="pink">

	<!-- mention that it's an error page -->
	<%@ page isErrorPage="true" %>
	<%@ page import="java.io.*" %>
	
	<%
		Exception e = (Exception) request.getAttribute("javax.servlet.error.exception");
		if(e != null){
			
			out.println("<h2>Error Details\n---------------</h2>");
			out.println("<p>"+e.getMessage()+"</p>");
			
			out.println("<h2>Stack Trace:\n----------------</h2>");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			out.println("<pre>"+sw.toString()+"</pre>");
			
		}else{
			out.println("<p> No Exception information available.</p>");
		}
	
	%>
	

</body>
</html>