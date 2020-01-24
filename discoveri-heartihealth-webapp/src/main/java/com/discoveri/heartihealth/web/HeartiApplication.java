package com.discoveri.heartihealth.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.discoveri.heartihealth")
public class HeartiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartiApplication.class, args);
	}

	/*
	 * @RestController static class SomeRestController {
	 * 
	 * @Autowired private PatientInfoServiceImple someService;
	 * 
	 * @RequestMapping(value = "/") public ResponseEntity<Patient> getPatientInfo()
	 * throws SQLException { try { Patient patient = someService.getPatientInfo();
	 * if (patient == null) { return new ResponseEntity<Patient>(patient,
	 * HttpStatus.NOT_FOUND); } else return new ResponseEntity<Patient>(patient,
	 * HttpStatus.OK); } catch (PatientExceptions e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } return null; } }
	 */
}
