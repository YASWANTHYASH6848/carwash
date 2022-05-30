package com.washer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingReview {

	private String review;
	private int rating;

	public RatingReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingReview(String review, int rating) {
		super();
		this.review = review;
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
