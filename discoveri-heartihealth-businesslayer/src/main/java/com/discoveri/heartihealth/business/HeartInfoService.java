package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;

public interface HeartInfoService {
	
	
	List<WeeklyPrediction> weekilyReport() throws PatientExceptions;
	
	List<CardioArrestDetection> totalCardioArrestDetection(int memberid) ;
	
	
}
