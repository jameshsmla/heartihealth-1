package com.discoveri.heartihealth.dto;

public class IntervalPrediction {
	private String interval;
	private String date;
	private int predicted;
	private int cured;

	public IntervalPrediction() {
		// TODO Auto-generated constructor stub
	}

	public IntervalPrediction(String interval, String date, int predicted, int cured) {
		super();
		this.interval = interval;
		this.date = date;
		this.predicted = predicted;
		this.cured = cured;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
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
