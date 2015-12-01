package com.companyname.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	} 

}
