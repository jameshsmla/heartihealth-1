package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.discoveri.heartihealth.exceptions.PatientExceptions;
import com.discoveri.heartihealth.model.Patient;
import com.discoveri.heartihealth.repository.PatientInfoRepo;

@Repository
public class PatientInfoRepoImpl  implements PatientInfoRepo{
	
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

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}
}
