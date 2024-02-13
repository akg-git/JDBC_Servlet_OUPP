package edu.oupp.traning.Advancejava.usecase.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Registration() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setFirstName(firstName);
        student.setLastName(lastName);

        StudentDAO studentDAO = new StudentDAO();
        boolean success=false;
		try {
			success = studentDAO.registerStudent(student);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Registration Result</title></head><body>");

        if (success) {
            out.println("<h1>Registration Successful!</h1>");
            out.println("<p>You have successfully registered as a student.</p>");
        } else {
            out.println("<h1>Registration Failed</h1>");
            out.println("<p>Sorry, an error occurred during registration. Please try again.</p>");
        }

        out.println("</body></html>");
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
