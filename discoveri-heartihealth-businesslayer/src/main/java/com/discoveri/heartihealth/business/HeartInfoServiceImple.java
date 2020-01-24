package com.discoveri.heartihealth.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.repository.HeartInfoRepo;

@Service
public class HeartInfoServiceImple implements HeartInfoService {

	@Autowired
	public HeartInfoRepo patientInfoRepo;

	

	@Override
	public List<WeeklyPrediction> weekilyReport() throws PatientExceptions {
		// TODO Auto-generated method stub
		return patientInfoRepo.weekilyReport();
	}



	@Override
	public List<CardioArrestDetection> totalCardioArrestDetection(int memberid) {
		// TODO Auto-generated method stub
		return patientInfoRepo.totalCardioArrestDetection(memberid);
	}
	
	
}
