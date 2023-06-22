package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql:///ebook-app","root","04&LU$NsA!R");
		} catch (Exception e) {

		  e.printStackTrace();
		}
		
		return conn;
	}

}
