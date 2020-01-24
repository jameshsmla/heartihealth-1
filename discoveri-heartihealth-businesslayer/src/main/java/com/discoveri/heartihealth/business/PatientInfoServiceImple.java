package com.discoveri.heartihealth.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;
import com.discoveri.heartihealth.repository.PatientInfoRepo;
import com.discoveri.heartihealth.repositoryImpl.PatientInfoRepoImpl;

@Service
public class PatientInfoServiceImple implements PatientInfoService {

	@Autowired
	public PatientInfoRepo patientInfoRepo;

	@Override
	public Patient getPatientInfo() throws PatientExceptions {
		PatientInfoRepoImpl pd = new PatientInfoRepoImpl();

		try {
			return pd.getPatientInfo();
		} catch (PatientExceptions e) {
			throw new PatientExceptions(e.getErrorMessage());
		}
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}
}
