/**
 * 
 */
package gov.edu.oupp.training.advancejava.restaurant.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Asish Kumar Gouda
 *
 */
public class DBConnection {
	
	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/restaurantdb";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
	public static Connection getDBConnection() throws SQLException {

		Connection conn = null;
		
		try{
			
			/**Load JDBC Driver*/			
			Class.forName(DRIVER);
			System.out.println("Drivers loaded..");
			
			/**register Driver Manager*/
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			System.out.println("Connection Established Successfully!!");
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}

}
