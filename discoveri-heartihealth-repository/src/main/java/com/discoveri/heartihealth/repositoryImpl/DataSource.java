package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.DriverManager;

import org.discoveri.heartihealth.configuration.DBConfiguration;

public class DataSource {
	public static Connection getConnetion() {
		Connection con=null;
		try {
<<<<<<< HEAD
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/heartihealth", "root", "mysql");
=======
			Class.forName(DBConfiguration.className);
			con = DriverManager.getConnection(DBConfiguration.dbUrl, DBConfiguration.userName, DBConfiguration.password);
>>>>>>> 0cce69bfbe869eb6ffeb9c5ac73687d94638438a
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
