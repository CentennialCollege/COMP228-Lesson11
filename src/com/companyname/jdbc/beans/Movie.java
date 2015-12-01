package com.companyname.jdbc.beans;

import java.sql.Date;

// MOVIE MODEL - JAVA BEAN

public class Movie {
	// PRIVATE INSTANCE VARIABLES ++++++++++++++++++++++
	private int _id;
	private String _name;
	private String _description;
	private Date _releaseDate;
	private double _rating;
	private String _genre;
	
	// PUBLIC PROPERTIES +++++++++++++++++++++++++++++++
	public int get_id() {
		return _id;
	}
	
	public void setId(int id) {
		this._id = id;
	}
	
	public String getName() {
		return this._name;
	}
	
	public void setName(String name) {
		this._name = name;
	}
	
	public String getDescription() {
		return this._description;
	}
	
	public void setDescription(String description) {
		this._description = description;
	}
	
	public Date getReleaseDate() {
		return this._releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this._releaseDate = releaseDate;
	}
	
	public double getRating() {
		return this._rating;
	}
	
	public void set_rating(double rating) {
		this._rating = rating;
	}
	
	public String getGenre() {
		return this._genre;
	}
	
	public void set_genre(String genre) {
		this._genre = genre;
	}
	
}
