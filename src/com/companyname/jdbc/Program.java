package com.companyname.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.companyname.jdbc.beans.Movie;

public class Program {


	public static void main(String[] args) throws SQLException {
		//MovieListController.displayAllRows();
		
		//READ
		/*
		System.out.println("______________________________________");
		System.out.println("Read a Row of Data");
		System.out.println("______________________________________");
		int readId = InputHelper.getIntegerInput("Select a Row to read: ");
		Movie readMovie = MovieListController.getRow(readId);
		
		if(readMovie == null) {
			System.err.println("No Rows where found");
		} else {
			System.out.println("Movie id: " + readMovie.getId());
			System.out.println("Movie Name: " + readMovie.getName());
			System.out.println("Movie Description: " + readMovie.getDescription());
			System.out.println("Movie Release Date: " + readMovie.getReleaseDate());
			System.out.println("Movie Rating: " + readMovie.getRating());
			System.out.println("Movie Genre: " + readMovie.getGenre());
		} // end READ
		*/
		
		//INSERT or "CREATE"
		/*
		System.out.println("______________________________________");
		System.out.println("Insert a Row of Data");
		System.out.println("______________________________________");
		Movie insertMovie = new Movie();
		
		
		try {
			insertMovie.setName(InputHelper.getStringInput("Enter Movie Name: "));
			insertMovie.setDescription(InputHelper.getStringInput("Enter a Description: "));
			insertMovie.setReleaseDate(InputHelper.getDateInput("Movie Release Date (YYYY-MM-DD): "));
			insertMovie.setRating(InputHelper.getDoubleInput("Enter a Rating: "));
			insertMovie.setGenre(InputHelper.getStringInput("Enter a Movie Genre: "));
			
			boolean result = MovieListController.insertRow(insertMovie);
			
			if(result) {
				System.out.println("New row with primary key " + insertMovie.getId() + " was inserted");
			}
			
		} catch (Exception exception) {
			System.err.println("Invalid Input: " + exception);
		} // End of Insert
		*/
		
		// UPDATE
		System.out.println("______________________________________");
		System.out.println("Update a Row of Data");
		System.out.println("______________________________________");
		int movieId = InputHelper.getIntegerInput("Select a row to update: ");
		
		Movie updateMovie = MovieListController.getRow(movieId);
		if(updateMovie == null) {
			System.err.println("Row not found");
			return;
		}
		
		Double updateRating = InputHelper.getDoubleInput("Enter a new Movie Rating: ");
		updateMovie.setRating(updateRating);
		
		try {
			if(MovieListController.updateRow(updateMovie)) {
				System.out.println("Row " + movieId + " was successfully updated");
			}
		} catch (Exception exception) {
			System.err.println(exception);
		} // end of update
		
		
		
		
	} 

}











