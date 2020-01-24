package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
<<<<<<< HEAD
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.dto.YearlyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
=======
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.SymptomPrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;
>>>>>>> 0cce69bfbe869eb6ffeb9c5ac73687d94638438a

public interface HeartInfoRepo {
	

<<<<<<< HEAD
	List<WeeklyPrediction> weekilyReport() throws PatientExceptions;

	List<YearlyPrediction> yearlyPredictions();
	
	List<CardioArrestDetection> totalCardioArrestDetection(int memberid);
	


=======
	List<IntervalPrediction> weeklyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyPredictions() throws HeartiExceptions;

	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
	
	List<SymptomPrediction> getChestPainDetection(String memberid);
	
	List<SymptomPrediction> getBloodPressureDetection(String memberid);
	
	List<SymptomPrediction> getCholesterolDetection(String memberid);
	
	List<LivePrediction> getLivePrediction(String memberid);
	
	LivePrediction getLivePredictionBySymptom(String memberid,String symptomType);
	
	
	List<CardioArrestDetection> totalCardioArrestDetection(String memberid);
>>>>>>> 0cce69bfbe869eb6ffeb9c5ac73687d94638438a
}
