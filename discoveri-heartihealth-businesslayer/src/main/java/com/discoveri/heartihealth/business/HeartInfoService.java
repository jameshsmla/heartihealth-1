package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

public interface HeartInfoService {

	List<IntervalPrediction> weekilyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyReport() throws HeartiExceptions;
	
	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
}
