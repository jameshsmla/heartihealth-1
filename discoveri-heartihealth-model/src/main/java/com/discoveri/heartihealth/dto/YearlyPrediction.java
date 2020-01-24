package com.discoveri.heartihealth.dto;

import java.util.Date;

public class YearlyPrediction {
	private Date year;
	private int predicted;
	private int cured;

	public YearlyPrediction() {

	}

	public YearlyPrediction(Date year, int predicted, int cured) {
		super();
		this.year = year;
		this.predicted = predicted;
		this.cured = cured;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
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
