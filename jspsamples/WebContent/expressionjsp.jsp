<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expression JSP Tag</title>
</head>
<body>
	Current Time: <%= java.util.Calendar.getInstance().getTime() %><br>
	Current Time(in  miliseconds): <%= java.util.Calendar.getInstance().getTimeInMillis() %><br>
	Current TimeZone: <%= java.util.Calendar.getInstance().getTimeZone() %><br>
	
</body>
</html>