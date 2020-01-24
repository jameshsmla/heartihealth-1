package com.discoveri.heartihealth.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.HeartInfoService;
import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;

@RestController
public class HeartiController {

	@Autowired
	private HeartInfoService heartInfoService;

	@RequestMapping(value = "/weeklyReport")
	public ResponseEntity<List<WeeklyPrediction>> weeklyReport() throws SQLException {
		try {
			List<WeeklyPrediction> weeklypredication = heartInfoService.weekilyReport();
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

	@RequestMapping(value = "/getTotalCardioArrestPrediction/{memberid}")

	public ResponseEntity<List<CardioArrestDetection>> getTotalCardioArrestPrediction(@PathVariable int memberid)
			throws SQLException {
		try {

			List<CardioArrestDetection> cardioArrestDetections = heartInfoService.totalCardioArrestDetection(memberid);
			if (cardioArrestDetections == null) {
				return new ResponseEntity<List<CardioArrestDetection>>(cardioArrestDetections, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<CardioArrestDetection>>(cardioArrestDetections, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}