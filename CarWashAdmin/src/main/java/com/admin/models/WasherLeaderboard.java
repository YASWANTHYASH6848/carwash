package com.admin.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "washerleaderboard")
public class WasherLeaderboard {

	private String washerName;
	private double waterSavedInliters;
	private int rank;

	public WasherLeaderboard(String washerName, double waterSavedInliters, int rank) {
		super();
		this.washerName = washerName;
		this.waterSavedInliters = waterSavedInliters;
		this.rank = rank;
	}

	public WasherLeaderboard() {
		
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public double getWaterSavedInliters() {
		return waterSavedInliters;
	}

	public void setWaterSavedInliters(double waterSavedInliters) {
		this.waterSavedInliters = waterSavedInliters;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
