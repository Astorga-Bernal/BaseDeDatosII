package src;

import java.sql.*;

public class DatabaseConnection {

	private String driver = "com.mysql.jdbc.Driver";
	private Connection connection = null;

	public DatabaseConnection(String url, String username, String password) {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Statement NewStatement() throws SQLException {
		try {
			Statement statement = connection.createStatement();
			return statement;
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public DatabaseMetaData newMataData() throws SQLException {
		try {
			DatabaseMetaData mdBasea = connection.getMetaData();
			return mdBasea;
		} catch (Exception e) {
			throw new SQLException();
		}
	}

}