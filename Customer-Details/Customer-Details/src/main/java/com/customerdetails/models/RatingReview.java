package com.customerdetails.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingReview {

    @NotEmpty(message = "please review the washer, review can't be empty!")
    private String review;
    private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public RatingReview(@NotEmpty(message = "please review the washer, review can't be empty!") String review,
			int rating) {
		super();
		this.review = review;
		this.rating = rating;
	}

	public RatingReview() {
		super();
		// TODO Auto-generated constructor stub
	}



}