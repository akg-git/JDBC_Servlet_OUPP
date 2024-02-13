package gov.edu.oupp.training.advancejava.restaurant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gov.edu.oupp.training.advancejava.restaurant.model.Reservation;
import gov.edu.oupp.training.advancejava.restaurant.model.ReservationDAO;
import gov.edu.oupp.training.advancejava.restaurant.model.Table;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	
	private ReservationDAO reservationDAO;

    public ReservationServlet() {
        super();
        reservationDAO = new ReservationDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//fetch data from registration page
		String customerName = request.getParameter("name");
		String phoneNumber = request.getParameter("phone");
		int partySize = Integer.parseInt(request.getParameter("party_size"));
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		Date date = Date.valueOf(request.getParameter("date"));
//		System.out.println(date);
		String timeslot = request.getParameter("time_slot");
		
		
		try{
			//form validation
			if (!isValidName(customerName) || !isValidPhone(phoneNumber) || !isValidNumber(partySize, tableId) || !isValidDate(date) || !isValidTime(timeslot) ) {
	            out.println("Invalid input. Please check your inputs and try again.");
	            return;
	        }
			
			//check table availability
			if(isAvailable(tableId) == 0)
			{
				out.print("Warning: Please select another table, as this table is already booked!!");
			}
			
		
			//create an reservation object
			Reservation reservation = new Reservation();
			reservation.setCustomerName(customerName);
			reservation.setPhoneNumber(phoneNumber);
			reservation.setPartySize(partySize);
			reservation.setTableId(tableId);
			reservation.setDate(date);
			reservation.setTime(timeslot);
			reservationDAO.partyFunctionality(reservation);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		response.sendRedirect("confirmation.jsp");
	
		
	}



	//check table availability
	private int isAvailable(int tableId) throws SQLException {
		
		Table table = new Table(tableId);
		int availability = table.isTableAvailable(tableId);
		
		return availability;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
/*	form validation methods*/
	
	private boolean isValidDate(Date date) {
		//regex for date
		String dateRegex = "(20)\\d{2}(\\/|-)(0[1-9]|1[1,2])(\\/|-)(0[1-9]|[12][0-9]|3[01])";
		//converting date to string and then match with regex
		String dateCheck = date.toString();
		return dateCheck.matches(dateRegex);
	}
	
	private boolean isValidTime(String timeslot) {
		if(timeslot!="Choose")
			return true;
		return false;
	}


	private boolean isValidNumber(int partySize, int tableId) {
		
		if(partySize>1 && partySize<50 && tableId>0 && tableId<11)
			return true;
		else 
			return false;
	}


	private boolean isValidPhone(String phoneNumber) {
		
		return phoneNumber.matches("[0-9]{10}");
	}


	private boolean isValidName(String customerName) {
		
		return customerName.matches("([\\w\\s\\w]+)");
	}

}
