/**
 * 
 */
package gov.edu.oupp.advancejava.training.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gov.edu.oupp.advancejava.training.mvc.model.Employee;

/**
 * @author AKG
 *
 */
public class EmployeeDAO {

	public final String DBURL = "jdbc:mysql://localhost:3306/ouppdb?allowPublicKeyRetrieval=true&useSSL=false";
	public final String USER = "root";
	public final String PASSWORD = "root";

	public int registerEmployee(Employee employee) {

		String INSERT_USERS_QUERY = "INSERT INTO employee ( first_name, last_name, username, password, address, contact) "
				+ "values (?, ?, ?, ?, ?, ?);";

		int result = 0;

		// step1: create DB connection
		try (Connection connection = DriverManager.getConnection(DBURL, USER, PASSWORD)) {

			// step2: create statement
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_QUERY);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(2, employee.getUserName());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(2, employee.getAddress());
			preparedStatement.setString(2, employee.getContact());

			System.out.println(preparedStatement);

			// step3: execute the query
			result = preparedStatement.executeUpdate();

		} catch (SQLException sqle) {
			// process sql exception
			printSQLException(sqle);
		}

		return result;

	}

	private void printSQLException(SQLException sqle) {

		for (Throwable e : sqle) {

			if (e instanceof SQLException) {
				e.printStackTrace(System.err);

				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + (e.getMessage()));

				Throwable t = sqle.getCause();

				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}

		}

	}

}
