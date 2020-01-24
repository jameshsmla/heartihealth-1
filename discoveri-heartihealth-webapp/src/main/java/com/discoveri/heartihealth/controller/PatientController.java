package com.discoveri.heartihealth.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.HeartInfoService;
import com.discoveri.heartihealth.business.HeartInfoServiceImple;
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

@RestController
public class PatientController {

	@Autowired
	private HeartInfoService heartInfoService;

	@RequestMapping(value = "/")
	public ResponseEntity<Patient> getPatientInfo() throws SQLException {
		try {
			Patient patient = heartInfoService.getPatientInfo();
			if (patient == null) {
				return new ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		} catch (PatientExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/weeklyReport")
	public ResponseEntity<List<WeeklyPrediction>> weeklyReport() throws SQLException {
		try {
			List<WeeklyPrediction> weeklypredication=heartInfoService.weekilyReport();
			if (weeklypredication == null) {
				return new ResponseEntity<List<WeeklyPrediction>>(weeklypredication, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<WeeklyPrediction>>(weeklypredication, HttpStatus.OK);
		} catch (PatientExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}