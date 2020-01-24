package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

public interface PatientInfoService {
	Patient getPatientInfo() throws PatientExceptions;

	List<Patient> getAllPatients();
}
