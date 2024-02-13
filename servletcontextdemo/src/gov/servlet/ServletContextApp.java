package gov.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletContextApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletContextApp() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		ServletContext context = getServletContext();
		
		String num1 = context.getInitParameter("num1");
		String num2 = context.getInitParameter("num2");
		
		pw.println("Num1 = "+num1);
		pw.println("Num2 = "+num2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
