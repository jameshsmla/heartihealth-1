package com.discoveri.heartihealth.web;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.PatientInfoServiceImple;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;

@SpringBootApplication(scanBasePackages = "com.discoveri.heartihealth")
public class HeartiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartiApplication.class, args);
	}

	@RestController
	static class SomeRestController {

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
}
