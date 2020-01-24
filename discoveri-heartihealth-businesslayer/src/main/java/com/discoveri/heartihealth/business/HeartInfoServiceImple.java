package com.discoveri.heartihealth.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
<<<<<<< HEAD
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
=======
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;
>>>>>>> 0cce69bfbe869eb6ffeb9c5ac73687d94638438a
import com.discoveri.heartihealth.repository.HeartInfoRepo;

@Service
public class HeartInfoServiceImple implements HeartInfoService {

	@Autowired
	public HeartInfoRepo patientInfoRepo;

<<<<<<< HEAD
	
=======
	@Override
	public List<IntervalPrediction> weeklyReport() throws HeartiExceptions {
		 
		return heartInfoRepo.weeklyReport();
	}
>>>>>>> 0cce69bfbe869eb6ffeb9c5ac73687d94638438a

	@Override
	public List<WeeklyPrediction> weekilyReport() throws HeartiExceptions {
		// TODO Auto-generated method stub
		return patientInfoRepo.weekilyReport();
	}


	@Override
	public List<CardioArrestDetection> totalCardioArrestDetection(String memberid) {
		// TODO Auto-generated method stub
		return heartInfoRepo.totalCardioArrestDetection(memberid);
	}

	@Override
	public List<LivePrediction> getLivePrediction(String memberid) {
		// TODO Auto-generated method stub
		return heartInfoRepo.getLivePrediction(memberid);
	}


	@Override
	public List<CardioArrestDetection> totalCardioArrestDetection(int memberid) {
		// TODO Auto-generated method stub
		return patientInfoRepo.totalCardioArrestDetection(memberid);
	}
	
	
}
