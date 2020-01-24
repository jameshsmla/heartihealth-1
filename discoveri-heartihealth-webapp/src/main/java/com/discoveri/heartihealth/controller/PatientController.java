package com.discoveri.heartihealth.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.PatientInfoServiceImple;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

@RestController
public class PatientController {

	@Autowired
	private PatientInfoServiceImple someService;

	@RequestMapping(value = "/")
	public ResponseEntity<Patient> getPatientInfo() throws SQLException {
		try {
			Patient patient = someService.getPatientInfo();
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
}