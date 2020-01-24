package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.discoveri.heartihealth.dto.WeeklyPrediction;
import com.discoveri.heartihealth.dto.YearlyPrediction;
import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;
import com.discoveri.heartihealth.repository.HeartInfoRepo;

@Repository
public class HeartInfoInfoRepoImpl  implements HeartInfoRepo{
	
	@Override
	public Patient getPatientInfo() throws PatientExceptions {
		Connection con=null;
		Patient emp;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from patient");
			emp = new Patient();
			while (rs.next()) {

				emp.setId(rs.getInt(1));
				emp.setSerialno(rs.getInt(2));
			} 
			con.close();
		} catch (Exception e) {
			throw new PatientExceptions(e.getMessage());
		}
		return emp;
	}

	/*
	 * @Override public List<Patient> getAllPatients() { Connection con=null;
	 * Patient emp; try { con = DataSource.getConnetion(); Statement stmt =
	 * con.createStatement(); ResultSet rs =
	 * stmt.executeQuery("select * from patient"); emp = new Patient(); while
	 * (rs.next()) {
	 * 
	 * emp.setId(rs.getInt(1)); emp.setSerialno(rs.getInt(2)); } con.close(); }
	 * catch (Exception e) { throw new PatientExceptions(e.getMessage()); } return
	 * null; }
	 */

	@Override
	public  List<WeeklyPrediction> weekilyReport() throws PatientExceptions {
	//	Patient emp;
		//WeeklyPrediction weeklyPrediction =new WeeklyPrediction();
		List<WeeklyPrediction> weeklyPredictions=new ArrayList<WeeklyPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DAYNAME(c.date) weeks, c.date as date, sum(c.cardioarrestdetected) as predicted, sum(d.isrecovered) as cured from memberinfo m inner join cardiodiagnosis c on m.member_id = c.memberinfo_member_id inner join diseasedetail d on c.cardio_id = d.cardiodiagnosis_cardio_id WHERE c.date >   DATE_SUB(NOW(), INTERVAL 1 WEEK) GROUP BY c.date ");
			//emp = new Patient();
			while (rs.next()) {
				WeeklyPrediction weeklyPrediction =new WeeklyPrediction();
				weeklyPrediction.setWeeks(rs.getString(1));
				weeklyPrediction.setDate(rs.getString(2));
				weeklyPrediction.setPredicted(rs.getInt(3));
				weeklyPrediction.setCured(rs.getInt(4));
				weeklyPredictions.add(weeklyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new PatientExceptions(e.getMessage());
		}
		return weeklyPredictions;
	}
	
	/*
	 * public static void main(String[] args) throws PatientExceptions {
	 * PatientInfoRepoImpl obj=new PatientInfoRepoImpl(); List<WeeklyPrediction>
	 * weeklyPredictions=obj.weekilyReport(); System.out.println("dfd"); }
	 */

	@Override
	public List<YearlyPrediction> yearlyPredictions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}
}
