package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/hospitaldb";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private static Connection conn;

	public static Connection getConn() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}