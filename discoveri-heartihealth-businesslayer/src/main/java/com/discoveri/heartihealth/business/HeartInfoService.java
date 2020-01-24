package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

public interface HeartInfoService {
	Patient getPatientInfo() throws PatientExceptions;

	List<Patient> getAllPatients();
	
	List<WeeklyPrediction> weekilyReport() throws PatientExceptions;
}
