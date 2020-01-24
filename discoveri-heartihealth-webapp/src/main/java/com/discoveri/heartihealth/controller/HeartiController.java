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
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

@RestController
public class HeartiController {

	@Autowired
	private HeartInfoService heartInfoService;

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
		List<IntervalPrediction> intervalReport = null;
		try {

			if (reportType.equalsIgnoreCase("weeklyReport")) {
				intervalReport = heartInfoService.weekilyReport();
			} else if (reportType.equalsIgnoreCase("yearlyReport")) {
				intervalReport = heartInfoService.yearlyReport();
			} else if (reportType.equalsIgnoreCase("monthlyReport")) {
				intervalReport = heartInfoService.monthlyReport();
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
	
	
	@RequestMapping(value = "/livePredictions/{memberid}")

	public ResponseEntity<List<LivePrediction>> getLivePrediction(@PathVariable int memberid)
			throws SQLException {
		try {
			List<LivePrediction> livePredictions = heartInfoService.getLivePrediction(memberid);
			if (livePredictions == null) {
				return new ResponseEntity<List<LivePrediction>>(livePredictions, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<LivePrediction>>(livePredictions, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}