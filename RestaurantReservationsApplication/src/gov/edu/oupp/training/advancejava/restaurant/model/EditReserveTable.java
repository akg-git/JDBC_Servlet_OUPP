/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Asish Kumar Gouda
 *
 */
public class EditReserveTable {

	public void editReservation(Connection conn, Reservation reservation) {
		
		try
		{
		
			final String SELECT_QUERY = "select * from table_reservation where reservation_id = ?;";
			PreparedStatement pst = conn.prepareStatement(SELECT_QUERY);
			
			pst.setString(1, reservation.getCustomerName());
			pst.setString(2, reservation.getPhoneNumber());
			pst.setInt(3, reservation.getPartySize());
			pst.setInt(4, reservation.getTableId());
			pst.setDate(5, reservation.getDate());
			pst.setString(6, reservation.getTime());
			
			int row = pst.executeUpdate();
			
			if(row>0){
				//do something
				//show added successfully
				System.out.println("Reservation successfull!!");
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
	}

}
