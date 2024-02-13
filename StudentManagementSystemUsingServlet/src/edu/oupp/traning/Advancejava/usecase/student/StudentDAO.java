package edu.oupp.traning.Advancejava.usecase.student;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Asish Kumar Gouda
 *
 */

public class StudentDAO {
	 public boolean registerStudent(Student student) throws SQLException, ClassNotFoundException {
		 Connection connection =Student.getConnection();
         
	        try {
	        		PreparedStatement preparedStatement = connection.prepareStatement(
	                        "INSERT INTO students (username, epassword, firstname, lastname) VALUES (?, ?, ?, ?)") ;
	               preparedStatement.setString(1, student.getUsername());
	               preparedStatement.setString(2, student.getPassword());
	               preparedStatement.setString(3, student.getFirstName());
	               preparedStatement.setString(4, student.getLastName());
	            int rowsAffected = preparedStatement.executeUpdate();
	            if(rowsAffected>0)
	            	return true;
	            else
	            	return false;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean validateLogin(String username, String password) throws ClassNotFoundException {
	        try (Connection connection = Student.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT * FROM students WHERE username = ? AND password = ?")) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            return resultSet.next();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
