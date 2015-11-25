package com.companyname.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CONFIGURATION UTILITY CLASS
public class DBConfig {
	// PRIVATE CONSTANTS
	private static final String USERNAME = "thoams";
	private static final String PASSWORD = "123456";
	private static final String CONN_STRING = "jdbc:mysql://localhost/moviedb";

	// UTILTITY METHOD that connects us to the mysql database
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	}
	
	// UTILITY METHOD that displays our errors in more detail
	public static void displayException(SQLException exception) {
		System.err.println("Error Message: " + exception.getMessage());
		System.err.println("Error Code: " + exception.getErrorCode());
		System.err.println("SQL State: " + exception.getSQLState());
	}
}
