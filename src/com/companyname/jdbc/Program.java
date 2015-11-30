package com.companyname.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	// SQL STATEMENT
	private static String QueryString = "SELECT * FROM movie_list WHERE rating >= ?";

	public static void main(String[] args) throws SQLException {
		double minRating = 4.0;
		
		ResultSet resultSet = null;
		
		try(	Connection connection  = DBConfig.getConnection();
				//Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				PreparedStatement statement = connection.prepareStatement(QueryString);
				)
		{
			statement.setDouble(1, minRating);
			resultSet = statement.executeQuery();
			System.out.println("Connected to Database...");
			while(resultSet.next()) {
			
			System.out.print("Movie: " + resultSet.getInt("id") + " - ");
			System.out.print(resultSet.getString("name") + " - ");
			System.out.print(resultSet.getString("genre") + " - ");
			System.out.println("Rating: " + resultSet.getDouble("rating"));
			}
			
			resultSet.last();
			System.out.println("Number of Rows: " + resultSet.getRow());
			
		} catch (SQLException exception) {
			DBConfig.displayException(exception);
		} finally {
			if(resultSet != null) {
				resultSet.close();
			}
		}

	}

}
