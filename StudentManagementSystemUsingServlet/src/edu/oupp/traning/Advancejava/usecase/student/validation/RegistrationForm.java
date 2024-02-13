package edu.oupp.traning.Advancejava.usecase.student.validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Asish Kumar Gouda
 *
 */

public class RegistrationForm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("Name");
        String email = request.getParameter("EmailId");
        String dateOfBirth = request.getParameter("DateOfBirth");
        String gender = request.getParameter("Gender");
        String course = request.getParameter("Course");
        String phone = request.getParameter("PhoneNumber");
        String address = request.getParameter("Address");

        try {
            if (!isValidName(name) || !isValidEmail(email) || !isValidPhone(phone)) {
                out.println("Invalid input. Please check your inputs and try again.");
                return;
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");

            String insertQuery = "INSERT INTO student2 (name, email, DateofBirth, gender, course, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, dateOfBirth);
                preparedStatement.setString(4, gender);
                preparedStatement.setString(5, course);
                preparedStatement.setString(6, phone);
                preparedStatement.setString(7, address);

                preparedStatement.executeUpdate();
            }

            con.close();

            out.println("Registration successful!<br>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Registration failed");
        }
        out.close();
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("[0-9]{10}");
    }

    private boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]{2,50}");
    }
}