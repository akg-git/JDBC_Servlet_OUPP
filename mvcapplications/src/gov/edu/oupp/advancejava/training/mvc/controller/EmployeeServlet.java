package gov.edu.oupp.advancejava.training.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.edu.oupp.advancejava.training.mvc.dao.EmployeeDAO;
import gov.edu.oupp.advancejava.training.mvc.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDAO employeeDAO;

    public EmployeeServlet() {
        super();
      
    }

    public void init(){
    	employeeDAO = new EmployeeDAO();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		
//		
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch data from View/UI
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employee employee = new Employee();
		
		//store data in employee object by setters
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUserName(userName);
		employee.setPassword(password);
		employee.setAddress(address);
		employee.setContact(contact);
		
//		request.getContextPath();
		
		try{
			employeeDAO.registerEmployee(employee);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect("employee_details.jsp");
	}

}
