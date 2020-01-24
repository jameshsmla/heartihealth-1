package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.SymptomPrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

public interface HeartInfoRepo {

	List<IntervalPrediction> weekilyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyPredictions() throws HeartiExceptions;

	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
	
	List<SymptomPrediction> getChestPainDetection(int memberid);
	
	List<SymptomPrediction> getBloodPressureDetection(int memberid);
	
	List<SymptomPrediction> getCholesterolDetection(int memberid);
	
	List<LivePrediction> getLivePrediction(int memberid);
	
	LivePrediction getLivePredictionBySymptom(int memberid,String symptomType);
	
	
	List<CardioArrestDetection> totalCardioArrestDetection(int memberid);
}
