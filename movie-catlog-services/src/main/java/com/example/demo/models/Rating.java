package com.example.demo.models;

public class Rating {
	private String movieId;
	private int Rating;
	
	public Rating() {
		
	}
	public Rating(String movieId, int Rating) {
		this.movieId = movieId;
		this.Rating = Rating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

}
