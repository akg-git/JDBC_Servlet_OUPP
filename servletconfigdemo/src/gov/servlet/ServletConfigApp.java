package gov.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletConfigApp extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ServletConfig config = getServletConfig();
		
		int num1 = Integer.parseInt( config.getInitParameter("number1"));
		int num2 = Integer.parseInt( config.getInitParameter("number2"));
		
		pw.println("Sum result of "+num1+"and "+num2 +" is  = "+(num1+num2));
		pw.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
