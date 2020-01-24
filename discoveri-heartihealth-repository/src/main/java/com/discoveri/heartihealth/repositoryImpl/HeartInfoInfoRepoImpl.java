package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.Symptom;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;
import com.discoveri.heartihealth.repository.HeartInfoRepo;

@Repository
public class HeartInfoInfoRepoImpl  implements HeartInfoRepo{

	@Override
	public  List<IntervalPrediction> weekilyReport() throws HeartiExceptions {
	//	Patient emp;
		//WeeklyPrediction weeklyPrediction =new WeeklyPrediction();
		List<IntervalPrediction> weeklyPredictions=new ArrayList<IntervalPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select year(c.date) as year,sum(c.cardioarrestdetected) as predicted, sum(d.isrecovered) as cured from cardiodiagnosis c  inner join memberinfo m inner join diseasedetail d on m.member_id = c.memberinfo_member_id and c.cardio_id = d.cardiodiagnosis_cardio_id  group by year(c.date); ");
			//emp = new Patient();
			while (rs.next()) {
				IntervalPrediction weeklyPrediction =new IntervalPrediction();
				weeklyPrediction.setInterval(rs.getString(1));
				weeklyPrediction.setDate(rs.getString(2));
				weeklyPrediction.setPredicted(rs.getInt(3));
				//weeklyPrediction.setCured(rs.getInt(4));
				weeklyPredictions.add(weeklyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new HeartiExceptions(e.getMessage());
		}
		return weeklyPredictions;
	}
	
	
	@Override
	public List<IntervalPrediction> yearlyPredictions() throws HeartiExceptions {
		List<IntervalPrediction> yearlyPredictions=new ArrayList<IntervalPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select year(c.date) as year,sum(c.cardioarrestdetected) as predicted, sum(d.isrecovered) as cured from cardiodiagnosis c  inner join memberinfo m inner join diseasedetail d on m.member_id = c.memberinfo_member_id and c.cardio_id = d.cardiodiagnosis_cardio_id  group by year(c.date);");
			//emp = new Patient();
			while (rs.next()) {
				IntervalPrediction yearlyPrediction =new IntervalPrediction();
				yearlyPrediction.setInterval(rs.getString(1));
				yearlyPrediction.setDate(rs.getString(2));
				yearlyPrediction.setPredicted(rs.getInt(3));
				//yearlyPrediction.setCured(rs.getInt(4));
				yearlyPredictions.add(yearlyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new HeartiExceptions(e.getMessage());
		}
		return yearlyPredictions;
	}


	@Override
	public List<IntervalPrediction> monthlyReport() throws HeartiExceptions {
		List<IntervalPrediction> monthlyPredictions=new ArrayList<IntervalPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select  MONTHNAME(STR_TO_DATE(month(c.date), '%m')) as month,sum(c.cardioarrestdetected) as predicted,sum(d.isrecovered) as cured from cardiodiagnosis c inner join memberinfo m inner join diseasedetail d on m.member_id = c.memberinfo_member_id and c.cardio_id = d.cardiodiagnosis_cardio_id  and year(c.date) = 2020 group by month(c.date);");
			//emp = new Patient();
			while (rs.next()) {
				IntervalPrediction monthlyPrediction =new IntervalPrediction();
				monthlyPrediction.setInterval(rs.getString(1));
				monthlyPrediction.setDate(rs.getString(2));
				monthlyPrediction.setPredicted(rs.getInt(3));
				//yearlyPrediction.setCured(rs.getInt(4));
				monthlyPredictions.add(monthlyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new HeartiExceptions(e.getMessage());
		}
		return monthlyPredictions;
	}


	@Override
	public List<Symptom> getSymtomCP() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Symptom> getSymtomBloodpressure() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Symptom> getSymtomSerumcholesterol() {
		// TODO Auto-generated method stub
		return null;
	}


	  @Override
	    public List<CardioArrestDetection> totalCardioArrestDetection(int memberid) {
	        // TODO Auto-generated method stub
	       
	        List<CardioArrestDetection> cardioArrestDetections =new ArrayList<CardioArrestDetection>();
	        Connection con=null;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid < 0)
	                 rs = stmt.executeQuery("select c.date,m.age,m.gender from memberinfo m inner join cardiodiagnosis c on c.memberinfo_member_id = m.member_id");
	            else
	                rs = stmt.executeQuery("select c.date,m.age,m.gender from memberinfo m inner join cardiodiagnosis c on m.member_id = c.memberinfo_member_id where m.member_id = "+memberid);
	            //emp = new Patient();
	            while (rs.next()) {
	                CardioArrestDetection cardioArrestDetection =new CardioArrestDetection();
	               
	                cardioArrestDetection.setTimestamp(rs.getString(1));
	                cardioArrestDetection.setAgeBelowThirty(rs.getInt(2) <= 30 ? true : false);
	                cardioArrestDetection.setMale(rs.getString(3).equalsIgnoreCase("male") ? true : false);
	           
	                cardioArrestDetections.add(cardioArrestDetection);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cardioArrestDetections;
	       
	    }
	
}
