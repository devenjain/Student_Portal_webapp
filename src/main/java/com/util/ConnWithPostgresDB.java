package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Connection class with MYSQL database..
 * 
 * */
public class ConnWithPostgresDB {

	private static String userName = "kojlqbhgbwucbz";
	private static String password = "de64f208e0c56ab14b22fa7b1c0ca54198303b36250b2e190fc226b8ae9e64d8";

	private static String connectionURL = "jdbc:postgresql://ec2-3-233-7-12.compute-1.amazonaws.com:5432/d987headsf1pjs?sslmode=require";
	private static String driverClass = "org.postgresql.Driver";

	public static Connection getConnPG() {

		Connection conn = null;
		// loading driver....
		// forname jvm force compile time --> new
		try {
			Class.forName(driverClass); // loaded..
			// getting connection...

			conn = DriverManager.getConnection(connectionURL, userName, password); //

			if (conn != null) {

				System.out.println("Connected with database...");
			} else {

				System.out.println("not connected with database..");
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return conn;

	}

}
