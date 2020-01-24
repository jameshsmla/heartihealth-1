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
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

@RestController
public class HeartiController {

	@Autowired
	private HeartInfoService heartInfoService;

	/*
	 * @RequestMapping(value = "/") public ResponseEntity<Patient> getPatientInfo()
	 * throws SQLException { try { Patient patient =
	 * heartInfoService.getPatientInfo(); if (patient == null) { return new
	 * ResponseEntity<Patient>(patient, HttpStatus.NOT_FOUND); } else return new
	 * ResponseEntity<Patient>(patient, HttpStatus.OK); } catch (HeartiExceptions e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } return null; }
	 */
	@RequestMapping(value = "/weeklyReport")
	public ResponseEntity<List<IntervalPrediction>> weeklyReport() throws SQLException {
		try {
			List<IntervalPrediction> weeklypredication = heartInfoService.weekilyReport();
			if (weeklypredication == null) {
				return new ResponseEntity<List<IntervalPrediction>>(weeklypredication, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<IntervalPrediction>>(weeklypredication, HttpStatus.OK);
		} catch (HeartiExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/yearlyReport")
	public ResponseEntity<List<IntervalPrediction>> yearlyReport() throws SQLException {
		try {
			List<IntervalPrediction> yearlypredication = heartInfoService.weekilyReport();
			if (yearlypredication == null) {
				return new ResponseEntity<List<IntervalPrediction>>(yearlypredication, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<IntervalPrediction>>(yearlypredication, HttpStatus.OK);
		} catch (HeartiExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/intervalReport/{reportType}")
	public ResponseEntity<List<IntervalPrediction>> intervalReport(@PathVariable String reportType)
			throws SQLException {
		List<IntervalPrediction> intervalReport =null;
		try {
			
			if (reportType.equalsIgnoreCase("weeklyReport")) {
				intervalReport = heartInfoService.weekilyReport();
			} else if (reportType.equalsIgnoreCase("yearlyReport")) {
				intervalReport=heartInfoService.yearlyReport();
			}
			else if(reportType.equalsIgnoreCase("monthlyReport")) {
				intervalReport=heartInfoService.monthlyReport();
			}
			if (intervalReport == null) {
				return new ResponseEntity<List<IntervalPrediction>>(intervalReport, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<IntervalPrediction>>(intervalReport, HttpStatus.OK);
		} catch (HeartiExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}