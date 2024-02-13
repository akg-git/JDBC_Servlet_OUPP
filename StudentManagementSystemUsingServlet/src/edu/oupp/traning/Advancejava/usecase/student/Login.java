package edu.oupp.traning.Advancejava.usecase.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Asish Kumar Gouda
 *
 */

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        StudentDAO studentDAO = new StudentDAO();
	        boolean isValid = false;
			try {
				isValid = studentDAO.validateLogin(username, password);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html><head><title>Login Result</title></head><body>");

	        if (isValid) {
	            out.println("<h1>Login Successful!</h1>");
	            out.println("<p>You have successfully logged in as a student.</p>");
	        } else {
	            out.println("<h1>Login Failed</h1>");
	            out.println("<p>Invalid username or password. Please try again.</p>");
	        }

	        out.println("</body></html>");
	    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
