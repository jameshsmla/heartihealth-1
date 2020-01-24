package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
<<<<<<< HEAD
import com.discoveri.heartihealth.exceptions.PatientExceptions;

public interface HeartInfoService {
	
	
	List<WeeklyPrediction> weekilyReport() throws PatientExceptions;
	
	List<CardioArrestDetection> totalCardioArrestDetection(int memberid) ;
=======
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

public interface HeartInfoService {

	List<IntervalPrediction> weeklyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyReport() throws HeartiExceptions;
	
	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
	
	List<CardioArrestDetection> totalCardioArrestDetection(String memberid) ;
	
	List<LivePrediction> getLivePrediction(String memberid);
>>>>>>> 0cce69bfbe869eb6ffeb9c5ac73687d94638438a
	
	
}
