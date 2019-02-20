package com.capg.phase2project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");
			return con;
		}catch(ClassNotFoundException c) {
			System.out.println(c);
		}catch(SQLException s) {
			System.out.println(s);
		}
		return null;
	}
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
