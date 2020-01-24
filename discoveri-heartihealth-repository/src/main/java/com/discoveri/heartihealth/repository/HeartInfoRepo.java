package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.dto.YearlyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;

public interface HeartInfoRepo {
	

	List<WeeklyPrediction> weekilyReport() throws PatientExceptions;

	List<YearlyPrediction> yearlyPredictions();
	
	List<CardioArrestDetection> totalCardioArrestDetection(int memberid);
	


}
