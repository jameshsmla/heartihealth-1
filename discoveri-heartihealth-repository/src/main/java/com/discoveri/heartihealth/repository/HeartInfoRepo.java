package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.Symptom;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

public interface HeartInfoRepo {

	List<IntervalPrediction> weekilyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyPredictions() throws HeartiExceptions;

	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
	
	List<Symptom> getSymtomCP();
	
	List<Symptom> getSymtomBloodpressure();
	
	List<Symptom> getSymtomSerumcholesterol();
}
