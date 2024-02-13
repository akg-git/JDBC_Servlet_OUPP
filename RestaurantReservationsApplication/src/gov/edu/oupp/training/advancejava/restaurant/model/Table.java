/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gov.edu.oupp.training.advancejava.restaurant.controller.DBConnection;

/**
 * @author Asish Kumar Gouda
 *
 */
public class Table {
	
	private int id;
	private int capacity;
	private int available;		//particular table available: 1: available and 0: unavailable
	
	//parameterized constructor
	public Table(int id) {
		super();
		this.id = id;
	}
	
	public Table(int id, int capacity, int available) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.available = available;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int isTableAvailable(int tableId)
	{
		Connection conn=null;
		ResultSet rs=null;
		
		int isAvailable = 0;
		
		try{
			conn= DBConnection.getDBConnection();
		
		if(conn == null){
			System.out.println("Connection Failed!!");
		}
		
		final String SELECT_QUERY = "select availability from table_details where table_id = ?;";
		PreparedStatement pst = conn.prepareStatement(SELECT_QUERY);
		pst.setInt(1, getId());
		rs = pst.executeQuery();
		
		if(rs!=null){
			while(rs.next()){
				isAvailable = rs.getInt("availability");
			}
		}
		
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try {
				if(conn!=null)
					conn.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return isAvailable;
	}
	

}
