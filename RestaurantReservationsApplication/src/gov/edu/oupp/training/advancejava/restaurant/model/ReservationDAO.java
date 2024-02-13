/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import gov.edu.oupp.training.advancejava.restaurant.controller.DBConnection;
import gov.edu.oupp.training.advancejava.restaurant.view.ReservationDashboard;

/**
 * @author Asish Kumar Gouda
 *
 */

public class ReservationDAO {
	
	public static void partyFunctionality(Reservation reservation) throws SQLException {
		
		ReservationDashboard rd = new ReservationDashboard();
		
		Connection conn = DBConnection.getDBConnection();
		
		if(conn == null){
			System.out.println("Connection Failed!!");
		}
		
		rd.reservationMenu(conn, reservation);
		

	}

}
