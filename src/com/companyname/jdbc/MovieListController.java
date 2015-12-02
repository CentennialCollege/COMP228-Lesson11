package com.companyname.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import com.companyname.jdbc.beans.Movie;

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
	public static Movie getRow(int id) throws SQLException {
		String SQLQuery = "SELECT * FROM movie_list WHERE id = ?";
		ResultSet resultSet = null;
		
		try(
			Connection connection = DBConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQLQuery);
		   ) {
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			//check to see if we received any data
			if(resultSet.next()) {
				Movie movie =  new Movie();
				movie.setId(id);
				movie.setName(resultSet.getString("name"));
				movie.setDescription(resultSet.getString("description"));
				movie.setReleaseDate(resultSet.getDate("release_date"));
				movie.setRating(resultSet.getDouble("rating"));
				movie.setGenre(resultSet.getString("genre"));
				return movie;
			} else {
				return null;
			}
		} catch(SQLException exception) {
			DBConfig.displayException(exception);
			return null;
		} finally {
			if(resultSet != null) {
				resultSet.close();
			}
		}
	}
	
	//INSERT ONE Row
	public static boolean insertRow(Movie movie) throws Exception {
		String SQLQuery = "INSERT into movie_list " +
	                      "(name, description, release_date, rating, genre) " +
				          "VALUES (?, ?, ?, ?, ?)";
		
		ResultSet keys = null;
		try(
			Connection connection = DBConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQLQuery, Statement.RETURN_GENERATED_KEYS);
			){
			
			statement.setString(1, movie.getName());
			statement.setString(2, movie.getDescription());
			statement.setDate(3, movie.getReleaseDate());
			statement.setDouble(4, movie.getRating());
			statement.setString(5, movie.getGenre());
			
			//get the number of return rows
			int affected = statement.executeUpdate();
			if(affected == 1) {
				keys = statement.getGeneratedKeys();
				keys.next();
				int newKey = keys.getInt(1);
				movie.setId(newKey);
			} else {
				System.err.println("No Rows Affected");
			}
			
			
		} catch(SQLException exception) {
			DBConfig.displayException(exception);
			return false;
		} finally {
			if(keys != null) {
				keys.close();
			}
		}
		
		return true;
	} // end of Insert one Row
		
	//UPDATE ONE Row
	public static boolean updateRow(Movie movie) throws Exception {
			
			String SQLQuery = "UPDATE movie_list SET " + 
			                  "name = ?, description = ?, release_date = ?, rating = ?, genre = ?" +
					          "WHERE id = ?";
			
			try(
				Connection connection = DBConfig.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQLQuery);
			   ) {
			
				statement.setString(1, movie.getName());
				statement.setString(2, movie.getDescription());
				statement.setDate(3, movie.getReleaseDate());
				statement.setDouble(4, movie.getRating());
				statement.setString(5, movie.getGenre());
				statement.setInt(6, movie.getId());
				
				int affected = statement.executeUpdate();
				if(affected == 1) {
					return true;
				} else {
					return false;
				}
				
			} catch (SQLException exception) {
				DBConfig.displayException(exception);
				return false;
			} 
			
		} // end of Update

	//DELETE ONE Row
	public static boolean deleteRow(int id) throws Exception {
		String SQLQuery = "DELETE from movie_list WHERE id = ?";
		
		try(
		   Connection connection = DBConfig.getConnection();
		   PreparedStatement statement = connection.prepareStatement(SQLQuery);
		   ) {
			
			statement.setInt(1, id);
			int affected = statement.executeUpdate();
			
			if(affected == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch(SQLException exception) {
			DBConfig.displayException(exception);
			return false;
		}
		
	}
	
	}  // End of MovieListController
	










