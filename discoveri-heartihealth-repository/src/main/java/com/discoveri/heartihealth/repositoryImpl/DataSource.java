package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	public static Connection getConnetion() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientheartdata", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
