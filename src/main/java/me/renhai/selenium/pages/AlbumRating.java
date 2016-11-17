package me.renhai.selenium.pages;

public class AlbumRating {

	private double rating;
	private int ratingSum;
	
	public AlbumRating(double rating, int ratingSum) {
		this.rating = rating;
		this.ratingSum = ratingSum;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getRatingSum() {
		return ratingSum;
	}
	public void setRatingSum(int ratingSum) {
		this.ratingSum = ratingSum;
	}
	@Override
	public String toString() {
		return "AlbumRating [rating=" + rating + ", ratingSum=" + ratingSum + "]";
	}
	
	
}
