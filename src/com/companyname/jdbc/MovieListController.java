package com.companyname.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

// Controller class for our Movie Model - Java Bean
public class MovieListController {
	//READ ALL DATA
	public static void displayAllRows() throws SQLException {
		String SQLQuery = "SELECT * FROM movie_list";
		
		try(
			Connection connection = DBConfig.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQLQuery);
		   ) {
			
			while(resultSet.next()) {
				StringBuffer buffer =  new StringBuffer();
				buffer.append("Movie " + resultSet.getInt("id") + ": ");
				buffer.append(resultSet.getString("name") + " - ");
				
				Date releaseDate = resultSet.getDate("release_date");
				DateFormat dateFormat = DateFormat.getDateInstance();
				String formattedDate = dateFormat.format(releaseDate);
				buffer.append("Released: " + formattedDate + " - ");
				buffer.append(resultSet.getDouble("rating") + " - ");
				buffer.append("Genre: " + resultSet.getString("genre"));
				
				System.out.println(buffer.toString());
			}
			
		} catch(SQLException exception) {
			DBConfig.displayException(exception);
		}
		
	} // End of displayAllRows
	
	//READ from ONE Row
	
	//INSERT ONE Row
	
	//UPDATE ONE Row
	
	//DELETE ONE Row

}
