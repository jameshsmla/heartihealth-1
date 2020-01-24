package com.discoveri.heartihealth.dto;

public class Symptom {
	private String date;
	private int symptom;

	public Symptom() {
		
	}

	public Symptom(String date, int symptom) {
		super();
		this.date = date;
		this.symptom = symptom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSymptom() {
		return symptom;
	}

	public void setSymptom(int symptom) {
		this.symptom = symptom;
	}

}
