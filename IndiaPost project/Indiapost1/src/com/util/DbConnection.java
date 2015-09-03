package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	public static Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	static {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Test1";
		String userName = "root";
		String password = "root";

		// registering the driver
		try {
			System.out.println("In Db class");
			Class.forName(driver);
			System.out.println("In Db class111");
			con = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getDbConnection() {
		return con;
	}

	public PreparedStatement getPrepareStatement(String query) {
		if (checkConnectionsAvailable()) {
			try {
				pstmt = con.prepareStatement(query);
				return pstmt;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pstmt;
	}

	public Statement getStatement() {
		if (checkConnectionsAvailable()) {
			try {
				stmt = con.createStatement();
				return stmt;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stmt;
	}

	public boolean checkConnectionsAvailable() {
		if (getDbConnection() != null) {
			return true;
		} else {
			return false;
		}
	}

}
