/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Asish Kumar Gouda
 *
 */


public class ReserveNewTable {
	
	public void reserveTables(Connection conn, Reservation reservation) throws SQLException{
		
		try
		{
		
			final String INSERT_QUERY = "insert into table_reservation(`name`,`phone_number`,`party_size`,`table_no`,`date`,`time_slot`) values( ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = conn.prepareStatement(INSERT_QUERY);
			
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
		}finally{
			
		}
	}

}
