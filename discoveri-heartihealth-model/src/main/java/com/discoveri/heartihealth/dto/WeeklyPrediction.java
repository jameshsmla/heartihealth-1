package com.discoveri.heartihealth.dto;

import java.util.Date;

public class WeeklyPrediction {
	private String weeks;
	private String date;
	private int predicted;
	private int cured ;
	
	public WeeklyPrediction() {
		// TODO Auto-generated constructor stub
	}

	public WeeklyPrediction(String weeks, String date, int predicted, int cured) {
		super();
		this.weeks = weeks;
		this.date = date;
		this.predicted = predicted;
		this.cured = cured;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPredicted() {
		return predicted;
	}

	public void setPredicted(int predicted) {
		this.predicted = predicted;
	}

	public int getCured() {
		return cured;
	}

	public void setCured(int cured) {
		this.cured = cured;
	}
	


}
