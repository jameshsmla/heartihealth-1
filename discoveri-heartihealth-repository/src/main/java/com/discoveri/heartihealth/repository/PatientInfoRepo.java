package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

public interface PatientInfoRepo {
	Patient getPatientInfo() throws PatientExceptions;
	
	List<Patient> getAllPatients();
	

}
