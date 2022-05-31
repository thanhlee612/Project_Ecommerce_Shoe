package com.laptrinhjava.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/quanlyhoso";
	private final static String user = "root";
	private final static String password = "123456";
	
	public static Connection getConnection() {	
		Connection cnn = null;
		try {
			Class.forName(JDBC_DRIVER);
			cnn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex) {
			System.err.println("Khong tim thay driver. Chi tiet: " + ex.getMessage());
		} catch (SQLException ex) {
			System.err.println("Khong the ket noi voi MySQL. Chi tiet: " + ex.getMessage());
		}
		return cnn;
	}
}
