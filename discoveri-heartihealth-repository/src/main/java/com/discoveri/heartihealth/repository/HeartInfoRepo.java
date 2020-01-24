package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.dto.YearlyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

public interface HeartInfoRepo {
	Patient getPatientInfo() throws PatientExceptions;

	List<Patient> getAllPatients();

	List<WeeklyPrediction> weekilyReport() throws PatientExceptions;

	List<YearlyPrediction> yearlyPredictions();

}
