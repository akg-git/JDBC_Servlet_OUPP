<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Process</title>
</head>
<body>

	<%
		
		String userId = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try{
			
			//Load Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javarace","root","root");
			if(conn==null){
				System.out.println("Connection Failed :(");
			}
			
			System.out.println("Connection Successfull :)");
			
			//create statement
			String isql = "insert into emp_reg values(?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(isql);
			
			pst.setString(1, userId);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, password);
			
			int k = pst.executeUpdate();
			
			if(k>0){
				response.sendRedirect("welcome.jsp");
			}else{
				System.out.println("message: registration failed!!");
				throw new Exception();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	%>

</body>
</html>