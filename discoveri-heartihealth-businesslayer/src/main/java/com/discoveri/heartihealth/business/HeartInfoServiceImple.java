package com.discoveri.heartihealth.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;
import com.discoveri.heartihealth.repository.HeartInfoRepo;
import com.discoveri.heartihealth.repositoryImpl.HeartInfoInfoRepoImpl;

@Service
public class HeartInfoServiceImple implements HeartInfoService {

	@Autowired
	public HeartInfoRepo patientInfoRepo;

	@Override
	public Patient getPatientInfo() throws PatientExceptions {
		//HeartInfoInfoRepoImpl pd = new HeartInfoInfoRepoImpl();

		try {
			return patientInfoRepo.getPatientInfo();
		} catch (PatientExceptions e) {
			throw new PatientExceptions(e.getErrorMessage());
		}
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WeeklyPrediction> weekilyReport() throws PatientExceptions {
		// TODO Auto-generated method stub
		return patientInfoRepo.weekilyReport();
	}
}
